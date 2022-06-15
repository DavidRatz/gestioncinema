package be.technifutur.reservation.configs.rabbit;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import be.technifutur.reservation.services.TicketService;
import be.technifutur.sharedclass.user.models.dtos.Cart2ReservDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageReceiver {
    
    @Autowired
    private TicketService service;

    @Bean
    public Consumer<Cart2ReservDTO> reccevoircart(){
        return (cart) -> {
            log.info("RECIEVED CART: " + cart);
            
            service.setTicket(cart);

            log.info("RESERVATION ADDED");
        };
    }
}
