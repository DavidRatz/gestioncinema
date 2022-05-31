package be.technifutur.user.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.user.models.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByUsername(String username);
    
}
