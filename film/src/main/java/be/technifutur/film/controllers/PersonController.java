package be.technifutur.film.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import be.technifutur.film.models.dtos.PersonDTO;
import be.technifutur.film.models.forms.PersonForm;
import be.technifutur.film.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping()
    public List<PersonDTO> getAllPersons() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping("/add")
    public PersonDTO postPerson(@RequestBody PersonForm personForm) {
        return service.insert(personForm);
    }

    @PutMapping("/{id}")
    public PersonDTO putPerson(@PathVariable Long id, @RequestBody PersonForm personForm) {
        return service.update(id, personForm);
    }

    @DeleteMapping("/{id}")
    public PersonDTO deletePerson(@PathVariable Long id) {
        return service.delete(id);
    }
}
