package be.technifutur.film.models.forms;

import java.util.List;

import lombok.Data;

@Data
public class PersonRoleForm {
    private List<Long> roles;
}
