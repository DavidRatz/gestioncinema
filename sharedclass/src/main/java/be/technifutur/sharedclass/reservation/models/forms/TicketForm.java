package be.technifutur.sharedclass.reservation.models.forms;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class TicketForm {
    private LocalDateTime dateShipping;
    private UUID refCart;
}
