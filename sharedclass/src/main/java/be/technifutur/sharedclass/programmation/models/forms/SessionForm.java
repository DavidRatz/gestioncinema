package be.technifutur.sharedclass.programmation.models.forms;

import java.time.*;
import java.util.UUID;

import lombok.Data;

@Data
public class SessionForm {
    private UUID refRoom;
    private UUID refMovie;
    private UUID refTheater;
    private LocalDateTime date;
}
