package be.technifutur.cinema.models.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.sharedclass.cinema.models.entities.*;

public interface TheaterRepository extends JpaRepository<Theater,Long> {

    Optional<Theater> findByRef(UUID ref);
    
}
