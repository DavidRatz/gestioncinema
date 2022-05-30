package be.technifutur.film.models.dtos;

import java.io.Serializable;

import be.technifutur.film.models.entities.Role;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleDTO implements Serializable {
    private final Long id;
    private final String description;

    public static RoleDTO of(Role role) {
        if( role == null )
            return null;

        return new RoleDTO(
            role.getId(),
            role.getDescription()
        );
    }
}
