package be.technifutur.film.services;

import be.technifutur.film.models.forms.*;
import be.technifutur.sharedclass.film.models.dtos.MovieDTO;

import java.util.List;
import java.util.UUID;

public interface MovieService {
    List<MovieDTO> getAll();
    MovieDTO getOne(Long id);
    MovieDTO insert(MovieForm form);
    MovieDTO delete(Long id);
    MovieDTO update(Long id, MovieForm form);
    MovieDTO patchPersons(Long id, MoviePersonForm form);
    MovieDTO patchGenres(Long id, MovieGenreForm form);
    MovieDTO patchFormats(Long id, MovieFormatForm form);
    MovieDTO getByRef(UUID ref);
}
