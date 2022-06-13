package be.technifutur.programmation.models.dtos;

import java.io.Serializable;
import java.time.*;
import java.util.UUID;

import be.technifutur.programmation.models.entities.Session;
import be.technifutur.sharedclass.film.models.dtos.MovieDTO;
import be.technifutur.sharedclass.cinema.models.dtos.*;
//import be.technifutur.sharedclass.room.models.dtos.RoomDTO;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionAllDataDTO implements Serializable{
    private final UUID ref;
    private final MovieDTO movieDTO;
    private final RoomDTO roomDTO;
    private final TheaterDTO theaterDTO;
    private final LocalDateTime date;

    public static SessionAllDataDTO of(Session session, MovieDTO movieDTO,RoomDTO roomDTO, TheaterDTO theaterDTO){
        if(session == null || movieDTO == null || theaterDTO == null){
            return null;
        }

        return new SessionAllDataDTO(
            session.getRef(), 
            movieDTO, 
            roomDTO,
            theaterDTO, 
            session.getDate()
        );
    }
}
