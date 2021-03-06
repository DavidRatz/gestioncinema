package be.technifutur.reservation.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import be.technifutur.sharedclass.reservation.models.dtos.TicketDTO;
import be.technifutur.sharedclass.reservation.models.forms.TicketForm;
import be.technifutur.reservation.services.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping()
    public List<TicketDTO> getAllTickets() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TicketDTO getTicket(@PathVariable Long id) {
        return service.getOne(id);
    }

    @GetMapping(params = "ref")
    public TicketDTO getTicket(@RequestParam UUID ref) {
        return service.getAllTicketByRefCart(ref);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public TicketDTO postTicket(@RequestBody TicketForm ticketForm) {
        return service.insert(ticketForm);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public TicketDTO putTicket(@PathVariable Long id, @RequestBody TicketForm ticketForm) {
        return service.update(id, ticketForm);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public TicketDTO deleteTicket(@PathVariable Long id) {
        return service.delete(id);
    }
}
