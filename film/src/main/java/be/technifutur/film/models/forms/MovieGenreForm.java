package be.technifutur.film.models.forms;

import java.util.List;

import lombok.Data;

@Data
public class MovieGenreForm {
    private List<Long> genres;
}
