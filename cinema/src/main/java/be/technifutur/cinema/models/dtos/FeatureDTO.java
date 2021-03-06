package be.technifutur.cinema.models.dtos;

import java.io.Serializable;

import be.technifutur.sharedclass.cinema.models.entities.Feature;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FeatureDTO implements Serializable {
    private final Long id;
    private final String description;

    public static FeatureDTO of(Feature feature) {
        if( feature == null )
            return null;

        return new FeatureDTO(
            feature.getId(),
            feature.getDescription()
        );
    }
}
