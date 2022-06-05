package be.technifutur.programmation.models.forms;

import java.time.*;
import java.util.UUID;

import lombok.Data;

@Data
public class SessionForm {
    private UUID refRoom;
    private UUID refMovie;
    private UUID refTheater;
    private LocalDate date;
    private LocalTime hour;
}
