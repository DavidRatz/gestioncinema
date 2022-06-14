package be.technifutur.programmation.models.forms;

import java.util.UUID;

import lombok.Data;

@Data
public class Session2CartForm {
    private UUID refSession;
    private String username;
    private int quantity;
}
