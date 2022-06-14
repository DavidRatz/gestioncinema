package be.technifutur.user.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import be.technifutur.sharedclass.programmation.models.dtos.Session2CartDTO;
import be.technifutur.sharedclass.user.models.dtos.Cart2ReservDTO;
import be.technifutur.user.models.entities.Cart;
import be.technifutur.user.models.entities.User;
import be.technifutur.user.models.repositories.CartRepository;
import be.technifutur.user.models.repositories.UserRepository;
import be.technifutur.user.services.CartService;

public class CartServiceImpl implements CartService {

    @Autowired
    private UserRepository uRepo;
    @Autowired
    private CartRepository cRepo;

    @Override
    public Cart2ReservDTO add2CartFromSessionAndSend2Reserv(Session2CartDTO session2CartDTO) {
        User user = uRepo.findByUsername(session2CartDTO.getUsername()).get();
        Cart cart = Cart.builder()
                        .user(user)
                        .quantity(session2CartDTO.getQuantity())
                        .price(9.50f)
                        .build();

        Cart cartSaved = cRepo.save(cart);
        return Cart2ReservDTO.builder().refCart(cartSaved.getRef()).build();
    }
    
}
