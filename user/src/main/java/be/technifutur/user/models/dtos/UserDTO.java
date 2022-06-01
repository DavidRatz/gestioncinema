package be.technifutur.user.models.dtos;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

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

    public UserDTO (User user, Authentication auth){       
        lastname = user.getLastname();
        firstname = user.getFirstname();
        email = user.getEmail();
        phoneNumber = user.getPhoneNumber();
        username = (String)auth.getPrincipal();
        password = null;
        carts = user.getCarts() == null ? null : user.getCarts().stream().map(CartDTO::of).toList();
        active = user.isActive();
        roles = auth.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .toList();
    }

    public static UserDTO of(User user){
        if(user == null){
            return null;
        }

        return new UserDTO(
            user.getLastname(),
            user.getFirstname(),
            user.getEmail(),
            user.getPhoneNumber(),
            user.getUsername(),
            user.getPassword(),
            user.getCarts() == null ? null : user.getCarts().stream().map(CartDTO::of).toList(),
            user.isActive(),
            user.getRoles()
        );
    }
}
