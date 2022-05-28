package be.technifutur.user.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.technifutur.user.models.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
