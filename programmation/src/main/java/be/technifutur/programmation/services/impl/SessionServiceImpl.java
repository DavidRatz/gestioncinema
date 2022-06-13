package be.technifutur.programmation.services.impl;

import be.technifutur.programmation.models.dtos.SessionAllDataDTO;
import be.technifutur.programmation.models.dtos.SessionDTO;
import be.technifutur.programmation.models.entities.Session;
import be.technifutur.programmation.models.forms.SessionForm;
import be.technifutur.programmation.models.repositories.SessionRepository;
import be.technifutur.programmation.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import be.technifutur.sharedclass.film.models.dtos.MovieDTO;
import be.technifutur.sharedclass.cinema.models.dtos.*;
import be.technifutur.programmation.configs.feign.*;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository repository;

    @Autowired
    private FilmFeign filmFeign;
    @Autowired
    private TheaterFeign theaterFeign;

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