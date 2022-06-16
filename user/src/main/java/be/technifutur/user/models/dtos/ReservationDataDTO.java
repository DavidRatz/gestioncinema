package be.technifutur.user.models.dtos;

import java.util.List;

import be.technifutur.sharedclass.programmation.models.dtos.SessionAllDataDTO;
import be.technifutur.sharedclass.reservation.models.dtos.TicketDTO;
import lombok.*;

@Data
@Builder
public class ReservationDataDTO {
    private final SessionAllDataDTO sessionDTO;
    private final CartDTO cartDTO;
    private final TicketDTO ticketDTO;

}
