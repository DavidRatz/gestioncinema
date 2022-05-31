package be.technifutur.cinema.services.impl;

import be.technifutur.cinema.models.dtos.TheaterDTO;
import be.technifutur.cinema.models.forms.TheaterForm;
import be.technifutur.cinema.models.entities.Address;
import be.technifutur.cinema.models.entities.Theater;
import be.technifutur.cinema.models.repositories.TheaterRepository;
import be.technifutur.cinema.services.TheaterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository repository;

    public TheaterServiceImpl(TheaterRepository repository) {
        this.repository = repository;
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
                            .address(address2Insert)
                            .build();
        return TheaterDTO.of(repository.save(toInsert));
    }

    @Override
    public TheaterDTO update(Long id, TheaterForm form) {
        Theater toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setName(form.getName());
        toUpdate.setDateCreation(form.getDateCreation());
        toUpdate.setPhoneNumber(form.getPhoneNumber());
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
