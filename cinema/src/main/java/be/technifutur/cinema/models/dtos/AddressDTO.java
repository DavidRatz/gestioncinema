package be.technifutur.cinema.models.dtos;

import java.io.Serializable;

import be.technifutur.cinema.models.entities.Address;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressDTO implements Serializable{
    private final Long id;
    private final String street;
    private final String number;
    private final int postCode;
    private final String city;
    private final String country;

    public static AddressDTO of(Address address) {
        if( address == null )
            return null;

        return new AddressDTO(
            address.getId(),
            address.getStreet(),
            address.getNumber(),
            address.getPostCode(),
            address.getCity(),
            address.getCountry()
        );
    }
}
