package be.technifutur.film.services;

import be.technifutur.film.models.dtos.PersonDTO;
import be.technifutur.film.models.forms.PersonForm;
import java.util.List;

public interface PersonService {
    List<PersonDTO> getAll();
    PersonDTO getOne(Long id);
    PersonDTO insert(PersonForm form);
    PersonDTO delete(Long id);
    PersonDTO update(Long id, PersonForm form);
}
