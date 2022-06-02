package be.technifutur.reservation.services;

import be.technifutur.reservation.models.dtos.TicketDTO;
import be.technifutur.reservation.models.forms.TicketForm;
import java.util.List;

public interface TicketService {
    List<TicketDTO> getAll();
    TicketDTO getOne(Long id);
    TicketDTO insert(TicketForm form);
    TicketDTO delete(Long id);
    TicketDTO update(Long id, TicketForm form);
}
