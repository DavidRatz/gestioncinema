package be.technifutur.cinema.services.impl;

import be.technifutur.sharedclass.cinema.models.dtos.RoomDTO;
import be.technifutur.cinema.models.forms.*;
import be.technifutur.sharedclass.cinema.models.entities.Feature;
import be.technifutur.sharedclass.cinema.models.entities.Room;
import be.technifutur.cinema.models.repositories.*;
import be.technifutur.cinema.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;
    private final TheaterRepository theaterRepo;
    private final FeatureRepository featureRepo;

    public RoomServiceImpl(RoomRepository repository, TheaterRepository theaterRepository, FeatureRepository featureRepo) {
        this.repository = repository;
        this.theaterRepo = theaterRepository;
        this.featureRepo = featureRepo;
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
    public List<RoomDTO> getRoomsbByIdCinema(Long idCinema) {
        return repository.findByTheaterId(idCinema).stream().map(RoomDTO::of).toList();
    }

    @Override
    public RoomDTO getByRef(UUID ref) {
        return repository.findByRef(ref).map(RoomDTO::of).orElseThrow();
    }

    @Override
    public RoomDTO insert(RoomForm form) {
        Room toInsert = Room.builder()
                        .number(form.getNumber())
                        .numberSeats(form.getNumberSeats())
                        .theater(theaterRepo.findById(form.getTheater()).orElseThrow())
                        .build();
        List<Feature> features = new ArrayList<>();
        for (Long idFeature : form.getFeatures()) {
            features.add(featureRepo.findById(idFeature).orElseThrow());
        }
        toInsert.setFeatures(features);
        return RoomDTO.of(repository.save(toInsert));
    }

    @Override
    public RoomDTO update(Long id, RoomUpdateForm form) {
        Room toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setNumberSeats(form.getNumberSeats());
        toUpdate = repository.save(toUpdate);
        return RoomDTO.of(toUpdate);
    }

    @Override
    public RoomDTO patchActive(Long id, boolean active) {
        Room toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setActive(active);
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
