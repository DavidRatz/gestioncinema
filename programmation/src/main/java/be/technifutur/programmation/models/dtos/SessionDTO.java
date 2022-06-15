package be.technifutur.programmation.models.dtos;

import java.io.Serializable;
import java.time.*;
import java.util.UUID;

import be.technifutur.sharedclass.programmation.models.entities.Session;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionDTO implements Serializable{
    private final Long id;
    private final UUID ref;
    private final UUID refRoom;
    private final UUID refMovie;
    private final UUID refTheater;
    private final LocalDateTime date;

    public static SessionDTO of(Session session){
        if(session == null){
            return null;
        }

        return new SessionDTO(
            session.getId(), 
            session.getRef(), 
            session.getRefRoom(), 
            session.getRefMovie(), 
            session.getRefTheater(),
            session.getDate()
            );
    }
}
