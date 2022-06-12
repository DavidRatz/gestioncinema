// package be.technifutur.film.models.entities;

// import java.util.List;
// import javax.persistence.*;
// import lombok.*;

// @Entity
// @Getter @Setter
// @Builder
// @AllArgsConstructor
// @NoArgsConstructor
// public class Person {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @Column(nullable = false)
//     private String lastname;
//     @Column(nullable = false)
//     private String firstname;
//     @Column(nullable = false)
//     private String country;
//     @ManyToMany
//     @JoinTable(name="Person_Role")
//     private List<Role> roles;
// }
