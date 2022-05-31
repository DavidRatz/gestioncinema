package be.technifutur.cinema.models.entities;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private int postCode;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;
    @OneToOne
    private Theater theater;
}
