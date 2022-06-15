package be.technifutur.sharedclass.reservation.models.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import be.technifutur.sharedclass.reservation.models.entities.Ticket;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketDTO implements Serializable {
    private final UUID ref;
    private final LocalDateTime dateShipping;
    private final UUID refCart;

    public static TicketDTO of(Ticket ticket){
        if(ticket == null){
            return null;
        }

        return new TicketDTO(
            ticket.getRef(),
            ticket.getDateShipping(),
            ticket.getRefCart()
        );
    }
}
