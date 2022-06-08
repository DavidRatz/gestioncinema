package be.technifutur.cinema.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import be.technifutur.cinema.models.dtos.TheaterDTO;
import be.technifutur.cinema.models.forms.TheaterForm;
import be.technifutur.cinema.services.TheaterService;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService service;

    @GetMapping()
    public List<TheaterDTO> getAllTheaters() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TheaterDTO getTheater(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public TheaterDTO postTheater(@RequestBody TheaterForm theaterForm) {
        return service.insert(theaterForm);
    }

    @PutMapping("/{id}")
    public TheaterDTO putTheater(@PathVariable Long id, @RequestBody TheaterForm theaterForm) {
        return service.update(id, theaterForm);
    }

    @PatchMapping("/{id}")
    public TheaterDTO patchTheaterActive(@PathVariable Long id, @RequestBody boolean active) {
        return service.patchActive(id, active);
    }

    @DeleteMapping("/{id}")
    public TheaterDTO deleteTheater(@PathVariable Long id) {
        return service.delete(id);
    }
}
