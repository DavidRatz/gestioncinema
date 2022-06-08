package be.technifutur.programmation.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import be.technifutur.programmation.models.dtos.SessionDTO;
import be.technifutur.programmation.models.forms.SessionForm;
import be.technifutur.programmation.services.SessionService;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService service;

    @GetMapping()
    public List<SessionDTO> getAllSessions() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SessionDTO getSession(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public SessionDTO postSession(@RequestBody SessionForm sessionForm) {
        return service.insert(sessionForm);
    }

    @PutMapping("/{id}")
    public SessionDTO putSession(@PathVariable Long id, @RequestBody SessionForm sessionForm) {
        return service.update(id, sessionForm);
    }

    @DeleteMapping("/{id}")
    public SessionDTO deleteSession(@PathVariable Long id) {
        return service.delete(id);
    }
}