package be.technifutur.film.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.film.models.entities.*;

public interface RoleRepository extends JpaRepository<Role,Long> {
    
}
