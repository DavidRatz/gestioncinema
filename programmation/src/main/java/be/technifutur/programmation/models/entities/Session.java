package be.technifutur.programmation.models.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @Builder.Default
    private UUID ref = UUID.randomUUID();
    @Column(nullable = false, unique = true)
    private UUID refRoom;
    @Column(nullable = false, unique = true)
    private UUID refMovie;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime hour;
}
