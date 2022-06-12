package be.technifutur.sharedclass.user.models.forms;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginForm {

    private String username;
    private String password;
}
