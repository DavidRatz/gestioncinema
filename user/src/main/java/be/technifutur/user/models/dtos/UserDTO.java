package be.technifutur.user.models.dtos;

import java.io.Serializable;
import java.util.List;

import be.technifutur.user.models.entities.User;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO implements Serializable {
    private final String lastname;
    private final String firstname;
    private final String email;
    private final String phoneNumber;
    private final String username;
    private final String password;
    private final List<CartDTO> carts;
    private final boolean active;
    private final List<String> roles;

    public static UserDTO of(User user){
        if(user == null){
            return null;
        }

        return new UserDTO(
            user.getLastname(),
            user.getFirstname(),
            user.getEmail(),
            user.getPhoneNumber(),
            user.getPhoneNumber(),
            user.getPhoneNumber(),
            user.getCarts() == null ? null : user.getCarts().stream().map(CartDTO::of).toList(),
            user.isActive(),
            user.getRoles()
        );
    }
}
