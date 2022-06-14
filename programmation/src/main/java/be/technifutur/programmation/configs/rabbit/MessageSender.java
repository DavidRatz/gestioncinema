package be.technifutur.programmation.configs.rabbit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import be.technifutur.sharedclass.programmation.models.dtos.Session2CartDTO;

import org.springframework.cloud.stream.function.StreamBridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MessageSender {
    @Autowired
    private StreamBridge streamBridge;

    public void sendSessionToUser(Session2CartDTO session2Cart) throws JsonProcessingException
    {
        streamBridge.send("envoisession-out-0", session2Cart);
    }
}
