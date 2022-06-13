package be.technifutur.film.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import be.technifutur.film.models.dtos.PersonDTO;
import be.technifutur.film.models.forms.*;
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

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PersonDTO postPerson(@RequestBody PersonForm personForm) {
        return service.insert(personForm);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PersonDTO putPerson(@PathVariable Long id, @RequestBody PersonForm personForm) {
        return service.update(id, personForm);
    }

    @PatchMapping("/{id}/roles")
    public PersonDTO patchRolesPerson(@PathVariable Long id, @RequestBody PersonRoleForm personRoleForm) {
        return service.patchRoles(id, personRoleForm);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PersonDTO deletePerson(@PathVariable Long id) {
        return service.delete(id);
    }
}
