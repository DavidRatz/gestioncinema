package be.technifutur.user.configs.rabbit;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import be.technifutur.sharedclass.programmation.models.dtos.Session2CartDTO;
import be.technifutur.user.services.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class StreamConfig {
    @Autowired
    private StreamBridge streamBridge;
    @Autowired
    private UserService service;

    @Bean
    public Function<Session2CartDTO, void> recevoirsessionenvoicart(){
        return (session) ->{
            log.info("Session RECEIVED - " + session);

            

            // Facture f = service.createFacture((int)r.getDate_arrive().until(r.getDate_depart(),ChronoUnit.DAYS), r.getRef());
            // return f;
        };
    }
}
