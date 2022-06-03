package be.technifutur.cinema.models.forms;

import java.util.List;

import be.technifutur.cinema.models.entities.Feature;
import be.technifutur.cinema.models.entities.Theater;
import lombok.Data;

@Data
public class RoomForm {
    private int number;
    private int numberSeats;
    private Long theater;
    private List<Long> features;
}
