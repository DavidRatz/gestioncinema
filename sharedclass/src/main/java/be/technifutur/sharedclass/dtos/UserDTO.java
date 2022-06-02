package be.technifutur.sharedclass.dtos;

import java.util.List;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private String username;
    private String password;
    private List<String> roles;
}
