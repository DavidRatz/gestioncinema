package be.technifutur.cinema.models.entities;

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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, columnDefinition = "varchar(255)")
    @Builder.Default
    @Type(type = "uuid-char")
    private UUID ref = UUID.randomUUID();
    @Column(nullable = false)
    private int number;
    @Column(nullable = false)
    private int numberSeats;
    @Column(nullable = false)
    @Builder.Default
    private boolean active = true;
    @ManyToOne
    private Theater theater;
    @ManyToMany
    @JoinTable(name="Room_Feature")
    private List<Feature> features;
}
