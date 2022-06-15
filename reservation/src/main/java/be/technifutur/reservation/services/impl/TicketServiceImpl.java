package be.technifutur.reservation.services.impl;

import be.technifutur.sharedclass.reservation.models.dtos.TicketDTO;
import be.technifutur.sharedclass.reservation.models.forms.TicketForm;
import be.technifutur.sharedclass.reservation.models.entities.Ticket;
import be.technifutur.reservation.models.repositories.TicketRepository;
import be.technifutur.reservation.services.TicketService;
import be.technifutur.sharedclass.user.models.dtos.Cart2ReservDTO;

import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;

    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TicketDTO> getAll() {
        return repository.findAll().stream().map(TicketDTO::of).toList();
    }

    @Override
    public TicketDTO getOne(Long id) {
        return repository.findById(id).map(TicketDTO::of).orElseThrow();
    }

    @Override
    public void setTicket(Cart2ReservDTO cart) {
        Ticket ticket = Ticket.builder()
                            .dateShipping(LocalDateTime.now())
                            .refCart(cart.getRefCart())
                            .build();
        for (int i = 0; i < cart.getQuantity(); i++) {
            repository.save(ticket);
        }
    }

    @Override
    public List<TicketDTO> getAllTicketByRefCart(UUID ref) {
       List<Ticket> list = repository.findAllByRefCart(ref);
        return list.stream().map(TicketDTO::of).toList();
    }

    @Override
    public TicketDTO insert(TicketForm form) {
        Ticket toInsert = Ticket.builder()
                            .dateShipping(form.getDateShipping())
                            .refCart(form.getRefCart())
                            .build();
        return TicketDTO.of(repository.save(toInsert));
    }

    @Override
    public TicketDTO update(Long id, TicketForm form) {
        Ticket toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setDateShipping(form.getDateShipping());
        toUpdate.setRefCart(form.getRefCart());
        toUpdate = repository.save(toUpdate);
        return TicketDTO.of(toUpdate);
    }

    @Override
    public TicketDTO delete(Long id) {
        Ticket toDelete = repository.findById(id).orElseThrow();
        repository.delete(toDelete);
        return TicketDTO.of(toDelete);
    }
}
