package be.technifutur.programmation.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import be.technifutur.programmation.models.dtos.*;
import be.technifutur.programmation.models.forms.*;
import be.technifutur.programmation.services.SessionService;
import be.technifutur.sharedclass.programmation.models.dtos.Session2CartDTO;

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

    @PostMapping("/search")
    public SessionAllDataDTO getSearchSession(@RequestBody SessionForm sessionForm) {
        return service.getSessionAllData(sessionForm);
    }

    @PostMapping("/addcart")
    public Session2CartDTO getSearchSession(@RequestBody Session2CartForm session2CartForm) {
        return service.addSession2Cart(session2CartForm);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public SessionDTO postSession(@RequestBody SessionForm sessionForm) {
        return service.insert(sessionForm);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public SessionDTO putSession(@PathVariable Long id, @RequestBody SessionForm sessionForm) {
        return service.update(id, sessionForm);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public SessionDTO deleteSession(@PathVariable Long id) {
        return service.delete(id);
    }
}