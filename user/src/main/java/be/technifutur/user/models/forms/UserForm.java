package be.technifutur.user.models.forms;

import lombok.Data;

@Data
public class UserForm {
    private String lastname;
    private String firstname;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
}
