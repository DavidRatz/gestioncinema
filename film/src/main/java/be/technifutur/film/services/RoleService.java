package be.technifutur.film.services;

import be.technifutur.film.models.dtos.RoleDTO;
import be.technifutur.film.models.forms.RoleForm;
import java.util.List;

public interface RoleService {
    List<RoleDTO> getAll();
    RoleDTO getOne(Long id);
    RoleDTO insert(RoleForm form);
    RoleDTO delete(Long id);
    RoleDTO update(Long id, RoleForm form);
}
