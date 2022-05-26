package be.technifutur.film.models.entities;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String country;
    @OneToMany(targetEntity = Role.class)
    private List<Role> roles;
}
