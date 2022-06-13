package be.technifutur.cinema.models.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.sharedclass.cinema.models.entities.*;

public interface RoomRepository extends JpaRepository<Room,Long> {

    Optional<Room> findByRef(UUID ref);

    List<Room> findByTheaterId(Long idCinema);
    
}
