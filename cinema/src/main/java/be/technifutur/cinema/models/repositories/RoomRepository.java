package be.technifutur.cinema.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.cinema.models.entities.*;

public interface RoomRepository extends JpaRepository<Room,Long> {
    
}
