package lu.smarthome.housemanager.controllers;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.domain.Room;
import lu.smarthome.housemanager.services.RoomService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.version.v1}/rooms")
@CrossOrigin("${app.api.cors}")
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public Room create(@RequestBody Room room) {
        return roomService.create(room);
    }

    @GetMapping("{id}")
    public Room show(@PathVariable Long id) {
        return roomService.read(id);
    }

    @PutMapping("{id}")
    public Room update(@PathVariable Long id, @RequestBody Room room) {
        return roomService.update(id, room);
    }

    @DeleteMapping(value = "{id}")
    public void destroy(@PathVariable Long id) {
        roomService.delete(id);
    }
}
