package be.technifutur.programmation.models.entities;

import java.time.*;
import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.Type;

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
    @Column(nullable = false, unique = true, columnDefinition = "varchar(255)")
    @Builder.Default
    @Type(type = "uuid-char")
    private UUID ref = UUID.randomUUID();
    @Column(nullable = false, unique = true, columnDefinition = "varchar(255)")
    @Type(type = "uuid-char")
    private UUID refRoom;
    @Column(nullable = false, unique = true, columnDefinition = "varchar(255)")
    @Type(type = "uuid-char")
    private UUID refMovie;
    @Column(nullable = false, unique = true, columnDefinition = "varchar(255)")
    @Type(type = "uuid-char")
    private UUID refTheater;
    @Column(nullable = false)
    private LocalDateTime date;
}
