package be.technifutur.reservation.models.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.sharedclass.reservation.models.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

	List<Ticket> findAllByRefCart(UUID ref);
    
}
