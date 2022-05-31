package be.technifutur.cinema.services.impl;

import be.technifutur.cinema.models.dtos.RoomDTO;
import be.technifutur.cinema.models.forms.RoomForm;
import be.technifutur.cinema.models.entities.Room;
import be.technifutur.cinema.models.repositories.*;
import be.technifutur.cinema.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;
    private final TheaterRepository theaterRepo;

    public RoomServiceImpl(RoomRepository repository, TheaterRepository theaterRepository) {
        this.repository = repository;
        this.theaterRepo = theaterRepository;
    }

    @Override
    public List<RoomDTO> getAll() {
        return repository.findAll().stream().map(RoomDTO::of).toList();
    }

    @Override
    public RoomDTO getOne(Long id) {
        return repository.findById(id).map(RoomDTO::of).orElseThrow();
    }

    @Override
    public RoomDTO insert(RoomForm form) {
        Room toInsert = Room.builder()
                        .number(form.getNumber())
                        .numberSeats(form.getNumberSeats())
                        .theater(theaterRepo.findById(form.getTheater()).orElseThrow())
                        .build();
        return RoomDTO.of(repository.save(toInsert));
    }

    @Override
    public RoomDTO update(Long id, RoomForm form) {
        Room toUpdate = repository.findById(id).orElseThrow();
    //set value;
        toUpdate = repository.save(toUpdate);
        return RoomDTO.of(toUpdate);
    }

    @Override
    public RoomDTO delete(Long id) {
        Room toDelete = repository.findById(id).orElseThrow();
        repository.delete(toDelete);
        return RoomDTO.of(toDelete);
    }
}
