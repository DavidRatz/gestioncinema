package be.technifutur.user.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import be.technifutur.user.models.dtos.UserDTO;
import be.technifutur.user.models.forms.UserForm;
import be.technifutur.user.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return service.getOne(id);
    }

    @GetMapping(params = "username")
    public UserDTO getUserByUsername(@RequestParam String username) {
        return service.getUserByUsername(username);
    }

    @PostMapping
    public UserDTO postUser(@RequestBody UserForm userForm) {
        return service.insert(userForm);
    }

    @PutMapping("/{id}")
    public UserDTO putUser(@PathVariable Long id, @RequestBody UserForm userForm) {
        return service.update(id, userForm);
    }

    @DeleteMapping("/{id}")
    public UserDTO deleteUser(@PathVariable Long id) {
        return service.delete(id);
    }
}
