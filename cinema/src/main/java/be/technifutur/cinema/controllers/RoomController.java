package be.technifutur.cinema.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import be.technifutur.sharedclass.cinema.models.dtos.RoomDTO;
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

    @GetMapping("/theater/{idCinema}")
    public List<RoomDTO> getAllRoomsByIdTheater(@PathVariable UUID idCinema) {
        return service.getRoomsbByIdCinema(idCinema);
    }

    @GetMapping(params = "ref")
    public RoomDTO getRoomByRef(@RequestParam UUID ref) {
        return service.getByRef(ref);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public RoomDTO postRoom(@RequestBody RoomForm roomForm) {
        return service.insert(roomForm);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public RoomDTO putRoom(@PathVariable Long id, @RequestBody RoomUpdateForm roomForm) {
        return service.update(id, roomForm);
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public RoomDTO patchRoomActive(@PathVariable Long id, @RequestBody boolean active) {
        return service.patchActive(id, active);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public RoomDTO deleteRoom(@PathVariable Long id) {
        return service.delete(id);
    }
}
