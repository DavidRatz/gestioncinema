package be.technifutur.user.models.dtos;

import java.io.Serializable;
import java.util.UUID;

import be.technifutur.user.models.entities.Cart;
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
}
