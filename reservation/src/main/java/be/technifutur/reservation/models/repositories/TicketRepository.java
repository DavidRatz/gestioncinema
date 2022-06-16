package be.technifutur.reservation.models.repositories;

import java.util.*;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.sharedclass.reservation.models.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

	Optional<Ticket> findByRefCart(UUID ref);
    
}
