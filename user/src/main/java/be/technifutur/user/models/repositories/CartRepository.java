package be.technifutur.user.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.user.models.entities.Cart;

public interface CartRepository extends JpaRepository<Cart,Long> {
    
}
