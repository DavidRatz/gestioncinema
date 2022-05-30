package be.technifutur.film.services;

import be.technifutur.film.models.dtos.FormatDTO;
import be.technifutur.film.models.forms.FormatForm;
import java.util.List;

public interface FormatService {
    List<FormatDTO> getAll();
    FormatDTO getOne(Long id);
    FormatDTO insert(FormatForm form);
    FormatDTO delete(Long id);
    FormatDTO update(Long id, FormatForm form);
}
