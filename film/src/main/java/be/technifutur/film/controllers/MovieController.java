package be.technifutur.film.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import be.technifutur.film.models.forms.*;
import be.technifutur.film.services.MovieService;
import be.technifutur.sharedclass.film.models.dtos.MovieDTO;

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

    @GetMapping("/{ref}")
    public MovieDTO getMovieByRef(@PathVariable UUID ref) {
        return service.getByRef(ref);
    }

    @PostMapping
    public MovieDTO postMovie(@RequestBody MovieForm movieForm) {
        return service.insert(movieForm);
    }

    @PutMapping("/{id}")
    public MovieDTO putMovie(@PathVariable Long id, @RequestBody MovieForm movieForm) {
        return service.update(id, movieForm);
    }

    @PatchMapping("/{id}/persons")
    public MovieDTO patchPersonsMovie(@PathVariable Long id, @RequestBody MoviePersonForm moviePersonForm) {
        return service.patchPersons(id, moviePersonForm);
    }
    @PatchMapping("/{id}/genres")
    public MovieDTO patchGenresMovie(@PathVariable Long id, @RequestBody MovieGenreForm movieGenreForm) {
        return service.patchGenres(id, movieGenreForm);
    }
    @PatchMapping("/{id}/formats")
    public MovieDTO patchFormatsMovie(@PathVariable Long id, @RequestBody MovieFormatForm movieFormatForm) {
        return service.patchFormats(id, movieFormatForm);
    }

    @DeleteMapping("/{id}")
    public MovieDTO deleteMovie(@PathVariable Long id) {
        return service.delete(id);
    }
}
