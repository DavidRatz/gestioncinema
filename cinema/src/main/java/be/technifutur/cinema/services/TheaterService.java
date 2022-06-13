package be.technifutur.cinema.services;

import be.technifutur.sharedclass.cinema.models.dtos.TheaterDTO;
import be.technifutur.cinema.models.forms.TheaterForm;
import java.util.List;
import java.util.UUID;

public interface TheaterService {
    List<TheaterDTO> getAll();
    TheaterDTO getOne(Long id);
    TheaterDTO insert(TheaterForm form);
    TheaterDTO delete(Long id);
    TheaterDTO update(Long id, TheaterForm form);
    TheaterDTO patchActive(Long id, boolean active);
    TheaterDTO getByRef(UUID ref);
}
