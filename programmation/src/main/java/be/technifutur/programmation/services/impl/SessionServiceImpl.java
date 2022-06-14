package be.technifutur.programmation.services.impl;

import be.technifutur.sharedclass.programmation.models.dtos.Session2CartDTO;
import be.technifutur.programmation.models.dtos.SessionAllDataDTO;
import be.technifutur.programmation.models.dtos.SessionDTO;
import be.technifutur.programmation.models.entities.Session;
import be.technifutur.programmation.models.forms.Session2CartForm;
import be.technifutur.programmation.models.forms.SessionForm;
import be.technifutur.programmation.models.repositories.SessionRepository;
import be.technifutur.programmation.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import be.technifutur.sharedclass.film.models.dtos.MovieDTO;
import be.technifutur.sharedclass.cinema.models.dtos.*;
import be.technifutur.programmation.configs.feign.*;
import be.technifutur.programmation.configs.rabbit.MessageSender;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository repository;

    @Autowired
    private FilmFeign filmFeign;
    @Autowired
    private TheaterFeign theaterFeign;

    @Autowired
    private MessageSender sender;

    public SessionServiceImpl(SessionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SessionDTO> getAll() {
        return repository.findAll().stream().map(SessionDTO::of).toList();
    }

    @Override
    public SessionDTO getOne(Long id) {
        return repository.findById(id).map(SessionDTO::of).orElseThrow();
    }

    @Override
    public SessionAllDataDTO getSessionAllData(SessionForm form) {
        MovieDTO movieDTO = filmFeign.getMovieByRef(form.getRefMovie());
        RoomDTO roomDTO = theaterFeign.getRoomByRef(form.getRefRoom());
        TheaterDTO theaterDTO = theaterFeign.getTheaterByRef(form.getRefTheater());

        Session session = repository.findByRefMovieAndRefTheaterAndDate(form.getRefMovie(),form.getRefTheater(),form.getDate()).orElseThrow();

        return SessionAllDataDTO.of(session, movieDTO, roomDTO, theaterDTO);
    }

    

    @Override
    public Session2CartDTO addSession2Cart(Session2CartForm session2CartForm) {
        Session2CartDTO session2Cart = Session2CartDTO.builder()
                                        .refSession(session2CartForm.getRefSession())
                                        .username(session2CartForm.getUsername())
                                        .quantity(session2CartForm.getQuantity())
                                        .build();
        try {
            sender.sendSessionToUser(session2Cart);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return session2Cart;
    }

    @Override
    public SessionDTO insert(SessionForm form) {
        Session toInsert = Session.builder()
                            .refMovie(form.getRefMovie())
                            .refRoom(form.getRefRoom())
                            .refTheater(form.getRefTheater())
                            .date(form.getDate())
                            .build();
        return SessionDTO.of(repository.save(toInsert));
    }

    @Override
    public SessionDTO update(Long id, SessionForm form) {
        Session toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setRefMovie(form.getRefMovie());
        toUpdate.setRefRoom(form.getRefRoom());
        toUpdate.setRefTheater(form.getRefTheater());
        toUpdate.setDate(form.getDate());
        toUpdate = repository.save(toUpdate);
        return SessionDTO.of(toUpdate);
    }

    @Override
    public SessionDTO delete(Long id) {
        Session toDelete = repository.findById(id).orElseThrow();
        repository.delete(toDelete);
        return SessionDTO.of(toDelete);
    }
}