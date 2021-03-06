package be.technifutur.cinema.models.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import be.technifutur.sharedclass.cinema.models.entities.*;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TheaterDTO implements Serializable {
    private final Long id;
    private final UUID ref;
    private final String name;
    private final LocalDate dateCreation;
    private final String phoneNumber;
    private final boolean active;
    private final AddressDTO address;
    private final List<RoomDTO> rooms;

    public static TheaterDTO of(Theater theater) {
        if( theater == null )
            return null;

        return new TheaterDTO(
            theater.getId(),
            theater.getRef(),
            theater.getName(),
            theater.getDateCreation(),
            theater.getPhoneNumber(),
            theater.isActive(),
            AddressDTO.of(theater.getAddress()),
            theater.getRooms() == null ? null : theater.getRooms().stream()
                    .map(RoomDTO::of)
                    .toList()
        );
    }

    @Data
    public static class AddressDTO{
        private final String street;
        private final String number;
        private final int postCode;
        private final String city;
        private final String country;
    
        public static AddressDTO of(Address address) {
            if( address == null )
                return null;
    
            return new AddressDTO(
                address.getStreet(),
                address.getNumber(),
                address.getPostCode(),
                address.getCity(),
                address.getCountry()
            );
        }
    }

    @Data
    public static class RoomDTO{
        private final Long id;
        private final UUID ref;
        private final int number;
        private final int numberSeats;
        private final boolean active;
        private final List<FeatureDTO> features;

        public static RoomDTO of(Room room){
            if( room == null )
                return null;
    
            return new RoomDTO(
                room.getId(),
                room.getRef(),
                room.getNumber(),
                room.getNumberSeats(),
                room.isActive(),
                room.getFeatures() == null ? null : room.getFeatures().stream()
                .map(FeatureDTO::of)
                .toList()
            );
        }
    }

    @Data
    public static class FeatureDTO{
        private final Long id;
        private final String description;

        public static FeatureDTO of(Feature feature){
            if( feature == null )
                return null;
    
            return new FeatureDTO(
                feature.getId(),
                feature.getDescription()
            );
        }
    }
}
