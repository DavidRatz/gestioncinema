package be.technifutur.sharedclass.film.models.dtos;

import java.io.Serializable;
import java.time.*;
import java.util.List;
import java.util.UUID;

import be.technifutur.sharedclass.film.models.entities.*;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieDTO implements Serializable{
    private final Long id;
    private final UUID ref;
    private final String title;
    private final String description;
    private final LocalTime duration;
    private final LocalDate releaseDate;
    private final Status status;
    private final List<FormatDTO> formats;
    private final List<GenreDTO> genres;
    private final List<PersonDTO> persons;

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
