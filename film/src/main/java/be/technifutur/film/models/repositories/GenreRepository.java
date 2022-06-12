package be.technifutur.film.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.sharedclass.film.models.entities.*;

public interface GenreRepository extends JpaRepository<Genre,Long> {
    
}
