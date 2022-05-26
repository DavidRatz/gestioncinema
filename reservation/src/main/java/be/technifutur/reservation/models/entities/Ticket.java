package be.technifutur.reservation.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private UUID ref;
    @Column(nullable = false)
    private LocalDateTime dateShipping;
    @Column(nullable = false, unique = true)
    private UUID refCart;
}
