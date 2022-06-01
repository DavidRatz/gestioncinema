package be.technifutur.film.models.forms;

import java.util.List;

import be.technifutur.film.models.entities.Role;
import lombok.Data;

@Data
public class PersonForm {
    private String lastname;
    private String firstname;
    private String country;
    private List<Long> roles;
}
