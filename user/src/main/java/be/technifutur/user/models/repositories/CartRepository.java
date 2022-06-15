package be.technifutur.user.models.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.user.models.entities.*;

public interface CartRepository extends JpaRepository<Cart,Long> {

    Optional<Cart> findByUser(User id);
    
}
