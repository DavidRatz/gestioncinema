package be.technifutur.user.configs.rabbit;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import be.technifutur.sharedclass.programmation.models.dtos.Session2CartDTO;
import be.technifutur.sharedclass.user.models.dtos.Cart2ReservDTO;
import be.technifutur.user.services.CartService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class StreamConfig {
    @Autowired
    private StreamBridge streamBridge;
    @Autowired
    private CartService service;

    @Bean
    public Function<Session2CartDTO, Cart2ReservDTO> recevoirsessionenvoicart(){
        return (session2CartDTO) ->{
            log.info("Session RECEIVED - " + session2CartDTO);

            
            return service.add2CartFromSessionAndSend2Reserv(session2CartDTO);
        };
    }
}
