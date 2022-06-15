package be.technifutur.programmation.models.repositories;

import java.time.*;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.sharedclass.programmation.models.entities.Session;

public interface SessionRepository extends JpaRepository<Session,Long> {

    Optional<Session> findByRefMovieAndRefTheaterAndDate(UUID refMovie, UUID refTheater, LocalDateTime date);

    Optional<Session> findByRef(UUID refSession);
    
}
