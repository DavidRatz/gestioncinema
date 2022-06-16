package be.technifutur.user.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import be.technifutur.sharedclass.programmation.models.dtos.Session2CartDTO;
import be.technifutur.sharedclass.programmation.models.dtos.SessionAllDataDTO;
import be.technifutur.sharedclass.reservation.models.dtos.TicketDTO;
import be.technifutur.sharedclass.user.models.dtos.Cart2ReservDTO;
import be.technifutur.user.configs.feign.*;
import be.technifutur.user.models.dtos.CartDTO;
import be.technifutur.user.models.dtos.ReservationDataDTO;
import be.technifutur.user.models.dtos.UserDTO;
import be.technifutur.user.models.entities.Cart;
import be.technifutur.user.models.entities.User;
import be.technifutur.user.models.forms.UserForm;
import be.technifutur.user.models.forms.LoginForm;
import be.technifutur.user.models.repositories.*;
import be.technifutur.user.services.UserService;


@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository uRepo;
    @Autowired
    private CartRepository cRepo;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SessionFeign session;
    @Autowired
    private TicketFeign ticket;

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
    public UserDTO getUserByUsername(String username) {
        return uRepo.findByUsername(username).map(UserDTO::of).orElseThrow();
    }
    

    @Override
    public ReservationDataDTO getReservationByUsername(String username) {
        CartDTO cartDTO = cRepo.findByUser(uRepo.findByUsername(username).orElseThrow()).map(CartDTO::of).orElseThrow();
        SessionAllDataDTO sessionDTO = session.getSearchSessionUser(cartDTO.getRefSeance());
        TicketDTO ticketDTO = ticket.getTickets(cartDTO.getRef());


        ReservationDataDTO reservationData = ReservationDataDTO.builder()
                                                .sessionDTO(sessionDTO)
                                                .cartDTO(cartDTO)
                                                .ticketDTO(ticketDTO)
                                                .build();
        return reservationData;
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
        User toUpdate = uRepo.findById(id).orElseThrow();
        toUpdate.setLastname(form.getLastname());
        toUpdate.setFirstname(form.getFirstname());
        toUpdate.setEmail(form.getEmail());
        toUpdate.setPhoneNumber(form.getPhoneNumber());
        toUpdate.setUsername(form.getUsername());
        toUpdate.setPassword(encoder.encode(form.getPassword()));
        toUpdate.setRoles(form.getRoles());
        toUpdate = uRepo.save(toUpdate);
        return UserDTO.of(toUpdate);
    }

    @Override
    public UserDTO delete(Long id) {
        User toDelete = uRepo.findById(id).orElseThrow();
        uRepo.delete(toDelete);
        return UserDTO.of(toDelete);
    }

}
