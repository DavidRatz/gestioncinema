package be.technifutur.cinema.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.cinema.models.entities.*;

public interface AddressRepository extends JpaRepository<Address,Long> {
    
}
