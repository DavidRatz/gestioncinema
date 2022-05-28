package be.technifutur.programmation.models.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private UUID ref;
    @Column(nullable = false, unique = true)
    private UUID refRoom;
    @Column(nullable = false, unique = true)
    private UUID refMovie;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime hour;
}
