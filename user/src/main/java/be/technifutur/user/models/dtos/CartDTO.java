package be.technifutur.user.models.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import be.technifutur.user.models.entities.Cart;
import be.technifutur.user.models.entities.User;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CartDTO implements Serializable {
    private final UUID ref;
    private final int quantity;
    private final float price;
    private final UUID refSeance;
    private final UserDTO user;

    public static CartDTO of(Cart cart){
        if(cart == null){
            return null;
        }

        return new CartDTO(
            cart.getRef(),
            cart.getQuantity(),
            cart.getPrice(),
            cart.getRefSeance(),
            UserDTO.of(cart.getUser())
        );
    }

    @Data
    public static class UserDTO{
        private final String lastname;
        private final String firstname;
        private final String email;
        private final String phoneNumber;
        private final String username;
        private final List<String> roles;

        public static UserDTO of(User user){
            if( user == null )
                return null;
    
            return new UserDTO(
                user.getLastname(),
                user.getFirstname(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getUsername(),
                user.getRoles()
            );
        }
    }
}
