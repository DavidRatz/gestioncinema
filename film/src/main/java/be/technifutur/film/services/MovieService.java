package be.technifutur.film.services;

import be.technifutur.film.models.dtos.MovieDTO;
import be.technifutur.film.models.forms.*;

import java.util.List;

public interface MovieService {
    List<MovieDTO> getAll();
    MovieDTO getOne(Long id);
    MovieDTO insert(MovieForm form);
    MovieDTO delete(Long id);
    MovieDTO update(Long id, MovieForm form);
    MovieDTO patchPersons(Long id, MoviePersonForm form);
    MovieDTO patchGenres(Long id, MovieGenreForm form);
    MovieDTO patchFormats(Long id, MovieFormatForm form);
}
