package be.technifutur.programmation.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.programmation.models.entities.Session;

public interface SessionRepository extends JpaRepository<Session,Long> {
    
}
