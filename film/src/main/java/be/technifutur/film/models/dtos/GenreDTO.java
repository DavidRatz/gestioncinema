package be.technifutur.film.models.dtos;

import java.io.Serializable;

import be.technifutur.film.models.entities.Genre;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GenreDTO implements Serializable {
    private final String description;

    public static GenreDTO of(Genre genre) {
        if( genre == null )
            return null;

        return new GenreDTO(
            genre.getDescription()
        );
    }
}
