package be.technifutur.film.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import be.technifutur.film.models.dtos.MovieDTO;
import be.technifutur.film.models.forms.MovieForm;
import be.technifutur.film.services.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping()
    public List<MovieDTO> getAllMovies() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MovieDTO getMovie(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping("/add")
    public MovieDTO postMovie(@RequestBody MovieForm movieForm) {
        return service.insert(movieForm);
    }

    @PutMapping("/{id}")
    public MovieDTO putMovie(@PathVariable Long id, @RequestBody MovieForm movieForm) {
        return service.update(id, movieForm);
    }

    @DeleteMapping("/{id}")
    public MovieDTO deleteMovie(@PathVariable Long id) {
        return service.delete(id);
    }
}
