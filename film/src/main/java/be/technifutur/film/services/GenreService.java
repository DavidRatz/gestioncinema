package be.technifutur.film.services;

import be.technifutur.film.models.dtos.GenreDTO;
import be.technifutur.film.models.forms.GenreForm;
import java.util.List;

public interface GenreService {
    List<GenreDTO> getAll();
    GenreDTO getOne(Long id);
    GenreDTO insert(GenreForm form);
    GenreDTO delete(Long id);
    GenreDTO update(Long id, GenreForm form);
}
