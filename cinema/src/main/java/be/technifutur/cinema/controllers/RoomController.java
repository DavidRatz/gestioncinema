package be.technifutur.cinema.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import be.technifutur.cinema.models.dtos.RoomDTO;
import be.technifutur.cinema.models.forms.*;
import be.technifutur.cinema.services.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping()
    public List<RoomDTO> getAllRooms() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RoomDTO getRoom(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping
    public RoomDTO postRoom(@RequestBody RoomForm roomForm) {
        return service.insert(roomForm);
    }

    @PutMapping("/{id}")
    public RoomDTO putRoom(@PathVariable Long id, @RequestBody RoomUpdateForm roomForm) {
        return service.update(id, roomForm);
    }

    @PatchMapping("/{id}")
    public RoomDTO patchRoomActive(@PathVariable Long id, @RequestBody boolean active) {
        return service.patchActive(id, active);
    }

    @DeleteMapping("/{id}")
    public RoomDTO deleteRoom(@PathVariable Long id) {
        return service.delete(id);
    }
}
