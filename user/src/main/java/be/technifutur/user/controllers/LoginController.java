package be.technifutur.user.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import be.technifutur.sharedclass.user.models.forms.LoginForm;
import be.technifutur.user.models.dtos.JwtDTO;
import be.technifutur.user.models.dtos.UserDTO;
import be.technifutur.user.models.entities.User;
import be.technifutur.user.models.repositories.UserRepository;
import be.technifutur.user.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService service;
    private final UserRepository userRepo;
    
    public LoginController(LoginService service, UserRepository userRepo){
        this.service=service;
        this.userRepo = userRepo;
    }
    
    @PostMapping
    public JwtDTO login(@RequestBody LoginForm form){
        return service.login(form);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(headers = "Authorization")
    public UserDTO validate(Authentication auth){
        User user = userRepo.findByUsername((String)auth.getPrincipal()).orElseThrow();
        return new UserDTO(user, auth);
    }
}
