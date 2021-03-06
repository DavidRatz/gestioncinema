package be.technifutur.cinema.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import be.technifutur.cinema.models.dtos.FeatureDTO;
import be.technifutur.cinema.models.forms.FeatureForm;
import be.technifutur.cinema.services.FeatureService;

@RestController
@RequestMapping("/feature")
public class FeatureController {

    @Autowired
    private FeatureService service;

    @GetMapping()
    public List<FeatureDTO> getAllFeatures() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public FeatureDTO getFeature(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public FeatureDTO postFeature(@RequestBody FeatureForm featureForm) {
        return service.insert(featureForm);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public FeatureDTO putFeature(@PathVariable Long id, @RequestBody FeatureForm featureForm) {
        return service.update(id, featureForm);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public FeatureDTO deleteFeature(@PathVariable Long id) {
        return service.delete(id);
    }
}