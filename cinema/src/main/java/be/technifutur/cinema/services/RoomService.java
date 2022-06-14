package be.technifutur.cinema.services;

import be.technifutur.sharedclass.cinema.models.dtos.RoomDTO;
import be.technifutur.cinema.models.forms.*;
import java.util.List;
import java.util.UUID;

public interface RoomService {
    List<RoomDTO> getAll();
    RoomDTO getOne(Long id);
    RoomDTO insert(RoomForm form);
    RoomDTO delete(Long id);
    RoomDTO update(Long id, RoomUpdateForm form);
    RoomDTO patchActive(Long id, boolean active);
    RoomDTO getByRef(UUID ref);
    List<RoomDTO> getRoomsbByIdCinema(UUID idCinema);
}