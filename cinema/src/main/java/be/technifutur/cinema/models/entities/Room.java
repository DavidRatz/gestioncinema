package be.technifutur.cinema.models.entities;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;
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
    @Column(nullable = false, unique = true)
    private UUID ref;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private int numberSeats;
    @Column(nullable = false)
    private boolean active;
    @ManyToOne
    private Theater theater;
    @ManyToMany
    @JoinTable(name="Room_Feature")
    private List<Feature> features;
}
