package be.technifutur.film.services.impl;

import be.technifutur.film.models.dtos.RoleDTO;
import be.technifutur.film.models.forms.RoleForm;
import be.technifutur.film.models.entities.Role;
import be.technifutur.film.models.repositories.RoleRepository;
import be.technifutur.film.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RoleDTO> getAll() {
        return repository.findAll().stream().map(RoleDTO::of).toList();
    }

    @Override
    public RoleDTO getOne(Long id) {
        return repository.findById(id).map(RoleDTO::of).orElseThrow();
    }

    @Override
    public RoleDTO insert(RoleForm form) {
        Role toInsert = Role.builder()
                            .description(form.getDescription())
                            .build();
        return RoleDTO.of(repository.save(toInsert));
    }

    @Override
    public RoleDTO update(Long id, RoleForm form) {
        Role toUpdate = repository.findById(id).orElseThrow();
        toUpdate.setDescription(form.getDescription());
        toUpdate = repository.save(toUpdate);
        return RoleDTO.of(toUpdate);
    }

    @Override
    public RoleDTO delete(Long id) {
        Role toDelete = repository.findById(id).orElseThrow();
        repository.delete(toDelete);
        return RoleDTO.of(toDelete);
    }
}
