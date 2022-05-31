package be.technifutur.user.services;

import be.technifutur.user.models.dtos.UserDTO;
import be.technifutur.user.models.forms.*;
import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO getOne(Long id);
    UserDTO insert(UserForm form);
    UserDTO delete(Long id);
    UserDTO update(Long id, UserForm form);
}
