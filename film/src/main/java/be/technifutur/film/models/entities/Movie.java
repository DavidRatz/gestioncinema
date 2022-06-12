// package be.technifutur.film.models.entities;

// import java.time.*;
// import java.util.List;
// import java.util.UUID;
// import javax.persistence.*;
// import lombok.*;

// @Entity
// @Getter @Setter
// @Builder
// @AllArgsConstructor
// @NoArgsConstructor
// public class Movie {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @Column(nullable = false, unique = true)
//     @Builder.Default
//     private UUID ref = UUID.randomUUID();
//     @Column(nullable = false)
//     private String title;
//     @Column(nullable = false, columnDefinition = "longtext")
//     private String description;
//     @Column(nullable = false)
//     private LocalTime duration;
//     @Column(nullable = false)
//     private LocalDate releaseDate;
//     @Column(nullable = false)
//     private Status status;
//     @ManyToMany
//     @JoinTable(name="Movie_Format")
//     private List<Format> formats;
//     @ManyToMany
//     @JoinTable(name="Movie_Genre")
//     private List<Genre> genres;
//     @ManyToMany
//     @JoinTable(name="Movie_Person")
//     private List<Person> persons;

// }
