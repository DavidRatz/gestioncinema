package be.technifutur.film.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import be.technifutur.film.models.dtos.GenreDTO;
import be.technifutur.film.models.forms.GenreForm;
import be.technifutur.film.services.GenreService;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService service;

    @GetMapping()
    public List<GenreDTO> getAllGenres() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GenreDTO getGenre(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public GenreDTO postGenre(@RequestBody GenreForm genreForm) {
        return service.insert(genreForm);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public GenreDTO putGenre(@PathVariable Long id, @RequestBody GenreForm genreForm) {
        return service.update(id, genreForm);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public GenreDTO deleteGenre(@PathVariable Long id) {
        return service.delete(id);
    }
}
