package be.technifutur.user.models.entities;

import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.Type;

import lombok.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, columnDefinition = "varchar(255)")
    @Builder.Default
    @Type(type = "uuid-char")
    private UUID ref = UUID.randomUUID();
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false, columnDefinition = "varchar(255)")
    @Type(type = "uuid-char")
    private UUID refSeance;
    @ManyToOne
    private User user;    
}
