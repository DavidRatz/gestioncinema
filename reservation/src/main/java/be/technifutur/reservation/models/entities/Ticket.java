package be.technifutur.reservation.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @Builder.Default
    private UUID ref = UUID.randomUUID();
    @Column(nullable = false)
    private LocalDateTime dateShipping;
    @Column(nullable = false, unique = true)
    private UUID refCart;
}
