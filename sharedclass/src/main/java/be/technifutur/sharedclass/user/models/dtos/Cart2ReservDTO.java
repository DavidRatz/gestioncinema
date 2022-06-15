package be.technifutur.sharedclass.user.models.dtos;

import java.util.UUID;

import lombok.*;

@Data
@Builder
public class Cart2ReservDTO {
    private final UUID refCart;
    private final int quantity;
}
