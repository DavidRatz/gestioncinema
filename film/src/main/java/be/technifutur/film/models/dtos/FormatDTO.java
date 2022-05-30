package be.technifutur.film.models.dtos;

import java.io.Serializable;

import be.technifutur.film.models.entities.Format;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FormatDTO implements Serializable {
    private final Long id;
    private final String description;

    public static FormatDTO of(Format format) {
        if( format == null )
            return null;

        return new FormatDTO(
            format.getId(),
            format.getDescription()
        );
    }
}
