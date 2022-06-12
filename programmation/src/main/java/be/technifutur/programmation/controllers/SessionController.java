package be.technifutur.programmation.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import be.technifutur.programmation.configs.feign.FilmFeign;
import be.technifutur.programmation.models.dtos.SessionDTO;
import be.technifutur.programmation.models.forms.SessionForm;
import be.technifutur.programmation.services.SessionService;
import be.technifutur.sharedclass.film.models.dtos.MovieDTO;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private SessionService service;
    @Autowired
    private FilmFeign film;

    @GetMapping()
    public List<SessionDTO> getAllSessions() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SessionDTO getSession(@PathVariable Long id) {
        return service.getOne(id);
    }

    @GetMapping("/search")
    public SessionDTO getSearchSession(@RequestBody SessionForm sessionForm) {
        MovieDTO movie = film.getMovieByRef(sessionForm.getRefMovie());
        return null;
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