package be.technifutur.sharedclass.programmation.models.dtos;

import java.util.UUID;

import lombok.*;

@Data
@Builder
public class Session2CartDTO {
    private final UUID refSession;
    private final String username;
    private final int quantity;
}
