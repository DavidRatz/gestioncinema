package be.technifutur.user.models.dtos;


import lombok.*;

@Data
@Builder
public class JwtDTO {
    private Long id;
    private String username;
    private String jwt;

}
