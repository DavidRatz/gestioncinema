package be.technifutur.cinema.models.forms;

import lombok.Data;

@Data
public class AddressForm {
    private String street;
    private String number;
    private int postCode;
    private String city;
    private String country;
}
