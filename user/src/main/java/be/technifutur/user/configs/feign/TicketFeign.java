package be.technifutur.user.configs.feign;

import java.util.List;
import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import be.technifutur.sharedclass.programmation.models.dtos.SessionAllDataDTO;
import be.technifutur.sharedclass.programmation.models.forms.SessionForm;
import be.technifutur.sharedclass.reservation.models.dtos.TicketDTO;

@FeignClient(
        name = "reservation-service"
)
public interface TicketFeign {
    @GetMapping("/ticket")
    public List<TicketDTO> getTickets(@RequestParam UUID ref);
}
