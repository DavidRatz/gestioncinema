package be.technifutur.film.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.film.models.entities.*;

public interface PersonRepository extends JpaRepository<Person,Long> {
    
}
