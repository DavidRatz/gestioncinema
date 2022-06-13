package be.technifutur.cinema.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import be.technifutur.sharedclass.cinema.models.dtos.TheaterDTO;
import be.technifutur.cinema.models.forms.TheaterForm;
import be.technifutur.cinema.services.TheaterService;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService service;

    @GetMapping
    public List<TheaterDTO> getAllTheaters() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TheaterDTO getTheater(@PathVariable Long id) {
        return service.getOne(id);
    }

    @GetMapping(params = "ref")
    public TheaterDTO getTheaterByRef(@RequestParam UUID ref) {
        return service.getByRef(ref);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public TheaterDTO postTheater(@RequestBody TheaterForm theaterForm) {
        return service.insert(theaterForm);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public TheaterDTO putTheater(@PathVariable Long id, @RequestBody TheaterForm theaterForm) {
        return service.update(id, theaterForm);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public TheaterDTO patchTheaterActive(@PathVariable Long id, @RequestBody boolean active) {
        return service.patchActive(id, active);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public TheaterDTO deleteTheater(@PathVariable Long id) {
        return service.delete(id);
    }
}
