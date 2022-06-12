package be.technifutur.film.models.dtos;

import java.io.Serializable;
import java.util.List;

import be.technifutur.sharedclass.film.models.entities.Person;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonDTO implements Serializable {
    private final Long id;
    private final String lastname;
    private final String firstname;
    private final String country;
    private final List<RoleDTO> roles;

    public static PersonDTO of(Person person) {
        if( person == null )
            return null;

        return new PersonDTO(
            person.getId(),
            person.getLastname(),
            person.getFirstname(),
            person.getCountry(),
            person.getRoles() == null ? null : person.getRoles().stream().map(RoleDTO::of).toList()
        );
    }
}
