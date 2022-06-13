package be.technifutur.film.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import be.technifutur.film.models.dtos.RoleDTO;
import be.technifutur.film.models.forms.RoleForm;
import be.technifutur.film.services.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping()
    public List<RoleDTO> getAllRoles() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RoleDTO getRole(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public RoleDTO postRole(@RequestBody RoleForm roleForm) {
        return service.insert(roleForm);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public RoleDTO putRole(@PathVariable Long id, @RequestBody RoleForm roleForm) {
        return service.update(id, roleForm);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public RoleDTO deleteRole(@PathVariable Long id) {
        return service.delete(id);
    }
}
