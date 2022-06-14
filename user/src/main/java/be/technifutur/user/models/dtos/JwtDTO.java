package be.technifutur.user.models.dtos;


import java.util.List;

import lombok.*;

@Data
@Builder
public class JwtDTO {
    private Long id;
    private String username;
    private String role;
    private String jwt;

}
