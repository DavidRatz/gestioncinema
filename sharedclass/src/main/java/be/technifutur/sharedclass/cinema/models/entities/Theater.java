package be.technifutur.sharedclass.cinema.models.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.Type;

import lombok.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, columnDefinition = "varchar(255)")
    @Builder.Default
    @Type(type = "uuid-char")
    private UUID ref = UUID.randomUUID();
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate dateCreation;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    @Builder.Default
    private boolean active = true;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "theater")
    private List<Room> rooms;
}
