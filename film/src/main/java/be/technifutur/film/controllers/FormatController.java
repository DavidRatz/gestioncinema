package be.technifutur.film.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import be.technifutur.film.models.dtos.FormatDTO;
import be.technifutur.film.models.forms.FormatForm;
import be.technifutur.film.services.FormatService;

@RestController
@RequestMapping("/format")
public class FormatController {

    @Autowired
    private FormatService service;

    @GetMapping()
    public List<FormatDTO> getAllFormats() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FormatDTO getFormat(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public FormatDTO postFormat(@RequestBody FormatForm formatForm) {
        return service.insert(formatForm);
    }

    @PutMapping("/{id}")
    public FormatDTO putFormat(@PathVariable Long id, @RequestBody FormatForm formatForm) {
        return service.update(id, formatForm);
    }

    @DeleteMapping("/{id}")
    public FormatDTO deleteFormat(@PathVariable Long id) {
        return service.delete(id);
    }
}
