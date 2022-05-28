package be.technifutur.film.models.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import be.technifutur.film.models.entities.*;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieDTO implements Serializable{
    private Long id;
    private UUID ref;
    private String title;
    private String description;
    private float duration;
    private LocalDate releaseDate;
    private Status status;
    private List<FormatDTO> formats;
    private List<GenreDTO> genres;
    private List<PersonDTO> persons;

    public static MovieDTO of(Movie movie){
        if(movie == null){
            return null;
        }

        return new MovieDTO(
            movie.getId(), 
            movie.getRef(), 
            movie.getTitle(), 
            movie.getDescription(), 
            movie.getDuration(), 
            movie.getReleaseDate(), 
            movie.getStatus(), 
            movie.getFormats() == null ? null : movie.getFormats().stream().map(FormatDTO::of).toList(),
            movie.getGenres() == null ? null : movie.getGenres().stream().map(GenreDTO::of).toList(),
            movie.getPersons() == null ? null : movie.getPersons().stream().map(PersonDTO::of).toList()
            );
    }

    @Data
    public static class FormatDTO{
        private final Long id;
        private final String description;

        public static FormatDTO of(Format format){
            if( format == null )
                return null;
    
            return new FormatDTO(
                format.getId(),
                format.getDescription()
            );
        }
    }

    @Data
    public static class GenreDTO{
        private final Long id;
        private final String description;

        public static GenreDTO of(Genre genre){
            if( genre == null )
                return null;
    
            return new GenreDTO(
                genre.getId(),
                genre.getDescription()
            );
        }
    }

    @Data
    public static class PersonDTO{
        private final Long id;
        private final String lastname;
        private final String firstname;
        private final String country;
        private final List<RoleDTO> roles;
        public static PersonDTO of(Person person){
            if( person == null )
                return null;
    
            return new PersonDTO(
                person.getId(),
                person.getFirstname(),
                person.getLastname(),
                person.getCountry(),
                person.getRoles() == null ? null : person.getRoles().stream().map(RoleDTO::of).toList()
            );
        }
    }

    @Data
    public static class RoleDTO{
        private final Long id;
        private final String description;

        public static RoleDTO of(Role role){
            if( role == null )
                return null;
    
            return new RoleDTO(
                role.getId(),
                role.getDescription()
            );
        }
    }
}
