package be.technifutur.film.models.forms;

import java.time.LocalDate;

import be.technifutur.film.models.entities.Status;
import lombok.Data;

@Data
public class MovieForm {
    private String title;
    private String description;
    private float duration;
    private LocalDate releaseDate;
    private Status status = Status.SOON;
}
