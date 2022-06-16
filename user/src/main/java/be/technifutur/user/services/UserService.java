package be.technifutur.user.services;

import be.technifutur.sharedclass.programmation.models.dtos.Session2CartDTO;
import be.technifutur.sharedclass.user.models.dtos.Cart2ReservDTO;
import be.technifutur.user.models.dtos.ReservationDataDTO;
import be.technifutur.user.models.dtos.UserDTO;
import be.technifutur.user.models.forms.*;
import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO getOne(Long id);
    UserDTO insert(UserForm form);
    UserDTO delete(Long id);
    UserDTO update(Long id, UserForm form);
    UserDTO getUserByUsername(String username);
    ReservationDataDTO getReservationByUsername(String username);
}
