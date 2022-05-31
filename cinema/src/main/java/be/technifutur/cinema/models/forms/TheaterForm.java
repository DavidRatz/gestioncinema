package be.technifutur.cinema.models.forms;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class TheaterForm {
    private String name;
    private LocalDate dateCreation;
    private String phoneNumber;
    private AddressForm address;
}
