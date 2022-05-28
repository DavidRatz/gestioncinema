package be.technifutur.reservation.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.reservation.models.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    
}
