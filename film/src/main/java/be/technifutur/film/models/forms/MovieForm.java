package be.technifutur.film.models.forms;

import java.time.LocalDate;
import java.util.List;

import be.technifutur.film.models.entities.*;
import lombok.Data;

@Data
public class MovieForm {
    private String title;
    private String description;
    private float duration;
    private LocalDate releaseDate;
    private Status status = Status.SOON;
    private List<Format> formats;
    private List<Genre> genres;
    private List<Person> persons;
}
