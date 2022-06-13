package be.technifutur.cinema.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.sharedclass.cinema.models.entities.*;

public interface FeatureRepository extends JpaRepository<Feature,Long> {
    
}
