package be.technifutur.reservation.services;

import be.technifutur.sharedclass.reservation.models.dtos.TicketDTO;
import be.technifutur.sharedclass.reservation.models.forms.TicketForm;
import be.technifutur.sharedclass.user.models.dtos.Cart2ReservDTO;

import java.util.List;
import java.util.UUID;

public interface TicketService {
    List<TicketDTO> getAll();
    TicketDTO getOne(Long id);
    TicketDTO insert(TicketForm form);
    TicketDTO delete(Long id);
    TicketDTO update(Long id, TicketForm form);
    void setTicket(Cart2ReservDTO cart);
    List<TicketDTO> getAllTicketByRefCart(UUID ref);
}
