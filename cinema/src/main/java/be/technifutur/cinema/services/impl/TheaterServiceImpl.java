package be.technifutur.cinema.services.impl;

import be.technifutur.sharedclass.cinema.models.dtos.TheaterDTO;
import be.technifutur.cinema.models.forms.TheaterForm;
import be.technifutur.sharedclass.cinema.models.entities.Address;
import be.technifutur.sharedclass.cinema.models.entities.Theater;
import be.technifutur.cinema.models.repositories.*;
import be.technifutur.cinema.services.TheaterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository repository;
    private final AddressRepository addressRepo;

    public TheaterServiceImpl(TheaterRepository repository, AddressRepository addressRepo) {
        this.repository = repository;
        this.addressRepo = addressRepo;
    }

    @Override
    public List<TheaterDTO> getAll() {
        return repository.findAll().stream().map(TheaterDTO::of).toList();
    }

    @Override
    public TheaterDTO getOne(Long id) {
        return repository.findById(id).map(TheaterDTO::of).orElseThrow();
    }

    @Override
    public TheaterDTO getByRef(UUID ref) {
        return repository.findByRef(ref).map(TheaterDTO::of).orElseThrow();
    }

    @Override
    public TheaterDTO insert(TheaterForm form) {
        Address address2Insert = Address.builder()
                                    .street(form.getAddress().getStreet())
                                    .number(form.getAddress().getNumber())
                                    .postCode(form.getAddress().getPostCode())
                                    .city(form.getAddress().getCity())
                                    .country(form.getAddress().getCountry())
                                    .build();
        Theater toInsert = Theater.builder()
                            .name(form.getName())
                            .dateCreation(form.getDateCreation())
                            .phoneNumber(form.getPhoneNumber())
                            .address(addressRepo.save(address2Insert))
                            .build();
        return TheaterDTO.of(repository.save(toInsert));
    }

    @Override
    public TheaterDTO update(Long id, TheaterForm form) {
        Theater toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setName(form.getName());
        toUpdate.setDateCreation(form.getDateCreation());
        toUpdate.setPhoneNumber(form.getPhoneNumber());

        Address address2Update = addressRepo.findById(toUpdate.getAddress().getId()).orElseThrow();
        address2Update.setStreet(form.getAddress().getStreet());
        address2Update.setNumber(form.getAddress().getNumber());
        address2Update.setPostCode(form.getAddress().getPostCode());
        address2Update.setCity(form.getAddress().getCity());
        address2Update.setCountry(form.getAddress().getCountry());
        address2Update = addressRepo.save(address2Update);

        toUpdate.setAddress(address2Update);
        toUpdate = repository.save(toUpdate);
        

        return TheaterDTO.of(toUpdate);
    }

    @Override
    public TheaterDTO patchActive(Long id, boolean active) {
        Theater toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setActive(active);
        toUpdate = repository.save(toUpdate);
        return TheaterDTO.of(toUpdate);
    }

    @Override
    public TheaterDTO delete(Long id) {
        Theater toDelete = repository.findById(id).orElseThrow();
        repository.delete(toDelete);
        return TheaterDTO.of(toDelete);
    }
}
