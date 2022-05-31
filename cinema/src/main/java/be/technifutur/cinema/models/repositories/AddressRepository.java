package be.technifutur.cinema.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.cinema.models.entities.*;

public interface AddressRepository extends JpaRepository<Address,Long> {

    Optional<Address> findByTheater(Long id);
    
}
