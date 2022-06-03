package be.technifutur.film.services;

import be.technifutur.film.models.dtos.PersonDTO;
import be.technifutur.film.models.forms.PersonForm;
import be.technifutur.film.models.forms.PersonRoleForm;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getAll();
    PersonDTO getOne(Long id);
    PersonDTO insert(PersonForm form);
    PersonDTO delete(Long id);
    PersonDTO update(Long id, PersonForm form);
    PersonDTO patchRoles(Long id, PersonRoleForm form);
}
