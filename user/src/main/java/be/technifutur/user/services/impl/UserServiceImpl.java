package be.technifutur.user.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import be.technifutur.user.models.dtos.UserDTO;
import be.technifutur.user.models.entities.User;
import be.technifutur.user.models.forms.UserForm;
import be.technifutur.user.models.forms.LoginForm;
import be.technifutur.user.models.repositories.UserRepository;
import be.technifutur.user.services.UserService;


@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository uRepo;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return uRepo.findByUsername(username).orElseThrow();
    }

    @Override
    public List<UserDTO> getAll() {
        return uRepo.findAll().stream().map(UserDTO::of).toList();
    }

    @Override
    public UserDTO getOne(Long id) {
        return uRepo.findById(id).map(UserDTO::of).orElseThrow();
    }

    @Override
    public UserDTO insert(UserForm form) {
        User toInsert = User.builder()
                        .lastname(form.getLastname())
                        .firstname(form.getFirstname())
                        .email(form.getEmail())
                        .phoneNumber(form.getPhoneNumber())
                        .username(form.getUsername())
                        .password(encoder.encode(form.getPassword()))
                        .roles(form.getRoles())
                        .build();
        return UserDTO.of(uRepo.save(toInsert));
    }

    @Override
    public UserDTO update(Long id, UserForm form) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDTO delete(Long id) {
        User toDelete = uRepo.findById(id).orElseThrow();
        uRepo.delete(toDelete);
        return UserDTO.of(toDelete);
    }

}
