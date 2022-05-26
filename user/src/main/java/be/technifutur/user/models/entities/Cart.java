package be.technifutur.user.models.entities;

import java.util.UUID;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private UUID ref;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private float price;
    @Column(nullable = false, unique = true)
    private UUID refSeance;
    @ManyToOne
    private User user;    
}
