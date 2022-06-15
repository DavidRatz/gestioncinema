package be.technifutur.sharedclass.reservation.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.Type;

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
    @Column(nullable = false, unique = true, columnDefinition = "varchar(255)")
    @Builder.Default
    @Type(type = "uuid-char")
    private UUID ref = UUID.randomUUID();
    @Column(nullable = false)
    private LocalDateTime dateShipping;
    @Column(nullable = false, unique = true)
    @Type(type = "uuid-char")
    private UUID refCart;
}
