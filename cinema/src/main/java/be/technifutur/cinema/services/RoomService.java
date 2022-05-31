package be.technifutur.cinema.services;

import be.technifutur.cinema.models.dtos.RoomDTO;
import be.technifutur.cinema.models.forms.*;
import java.util.List;

public interface RoomService {
    List<RoomDTO> getAll();
    RoomDTO getOne(Long id);
    RoomDTO insert(RoomForm form);
    RoomDTO delete(Long id);
    RoomDTO update(Long id, RoomUpdateForm form);
    RoomDTO patchActive(Long id, boolean active);
}