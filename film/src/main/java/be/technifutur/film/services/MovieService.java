package be.technifutur.film.services;

import be.technifutur.film.models.dtos.MovieDTO;
import be.technifutur.film.models.forms.MovieForm;
import java.util.List;

public interface MovieService {
    List<MovieDTO> getAll();
    MovieDTO getOne(Long id);
    MovieDTO insert(MovieForm form);
    MovieDTO delete(Long id);
    MovieDTO update(Long id, MovieForm form);
}
