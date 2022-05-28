package be.technifutur.cinema.models.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private UUID ref;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate dateCreation;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private boolean active;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "theater")
    private List<Room> rooms;
}
