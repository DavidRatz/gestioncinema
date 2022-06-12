package be.technifutur.film.models.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.sharedclass.film.models.entities.*;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    Optional<Movie> findByRef(UUID ref);
    
}
