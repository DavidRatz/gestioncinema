package be.technifutur.film.models.forms;

import java.time.*;
import java.util.List;

import be.technifutur.sharedclass.film.models.entities.*;
import lombok.Data;

@Data
public class MovieForm {
    private String title;
    private String description;
    private LocalTime duration;
    private LocalDate releaseDate;
    private Status status = Status.SOON;
    private List<Long> formats;
    private List<Genre> genres;
    private List<Long> persons;
}
