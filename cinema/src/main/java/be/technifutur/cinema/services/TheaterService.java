package be.technifutur.cinema.services;

import be.technifutur.cinema.models.dtos.TheaterDTO;
import be.technifutur.cinema.models.forms.TheaterForm;
import java.util.List;

public interface TheaterService {
    List<TheaterDTO> getAll();
    TheaterDTO getOne(Long id);
    TheaterDTO insert(TheaterForm form);
    TheaterDTO delete(Long id);
    TheaterDTO update(Long id, TheaterForm form);
    TheaterDTO patchActive(Long id, boolean active);
}
