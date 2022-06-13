package be.technifutur.programmation.configs.feign;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import be.technifutur.sharedclass.cinema.models.dtos.*;

@FeignClient(
        name = "cinema-service"
)
public interface TheaterFeign {
    @GetMapping("/theater")
    public TheaterDTO getTheaterByRef(@RequestParam UUID ref);
    @GetMapping("/room")
    public RoomDTO getRoomByRef(@RequestParam UUID ref);
}
