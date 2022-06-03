package be.technifutur.film.models.forms;

import java.util.List;

import lombok.Data;

@Data
public class MovieFormatForm {
    private List<Long> formats;
}
