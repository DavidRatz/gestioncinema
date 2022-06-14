package be.technifutur.user.services;

import be.technifutur.sharedclass.programmation.models.dtos.Session2CartDTO;
import be.technifutur.sharedclass.user.models.dtos.Cart2ReservDTO;

public interface CartService {
    Cart2ReservDTO add2CartFromSessionAndSend2Reserv(Session2CartDTO session2CartDTO);
}
