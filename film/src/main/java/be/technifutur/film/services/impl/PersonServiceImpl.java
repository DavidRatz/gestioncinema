package be.technifutur.film.services.impl;

import be.technifutur.film.models.dtos.PersonDTO;
import be.technifutur.film.models.forms.PersonForm;
import be.technifutur.film.models.forms.PersonRoleForm;
import be.technifutur.film.models.entities.Person;
import be.technifutur.film.models.repositories.PersonRepository;
import be.technifutur.film.models.repositories.RoleRepository;
import be.technifutur.film.services.PersonService;
import be.technifutur.film.utils.FormConverterList;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;
    private final RoleRepository roleRepo;

    public PersonServiceImpl(PersonRepository repository,RoleRepository roleRepo) {
        this.repository = repository;
        this.roleRepo = roleRepo;
    }

    @Override
    public List<PersonDTO> getAll() {
        return repository.findAll().stream().map(PersonDTO::of).toList();
    }

    @Override
    public PersonDTO getOne(Long id) {
        return repository.findById(id).map(PersonDTO::of).orElseThrow();
    }

    @Override
    public PersonDTO insert(PersonForm form) {
        Person toInsert = Person.builder()
                            .lastname(form.getLastname())
                            .firstname(form.getFirstname())
                            .country(form.getCountry())
                            .build();
        toInsert.setRoles(FormConverterList.convertIdList2EntityList(roleRepo,form.getRoles()));
        return PersonDTO.of(repository.save(toInsert));
    }

    @Override
    public PersonDTO update(Long id, PersonForm form) {
        Person toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setLastname(form.getLastname());
        toUpdate.setFirstname(form.getFirstname());
        toUpdate.setCountry(form.getCountry());
        toUpdate.setRoles(FormConverterList.convertIdList2EntityList(roleRepo,form.getRoles()));
        toUpdate = repository.save(toUpdate);
        return PersonDTO.of(toUpdate);
    }

    @Override
    public PersonDTO patchRoles(Long id, PersonRoleForm form) {
        Person toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setRoles(FormConverterList.convertIdList2EntityList(roleRepo,form.getRoles()));
        toUpdate = repository.save(toUpdate);
        return PersonDTO.of(toUpdate);
    }

    @Override
    public PersonDTO delete(Long id) {
        Person toDelete = repository.findById(id).orElseThrow();
        repository.delete(toDelete);
        return PersonDTO.of(toDelete);
    }
}