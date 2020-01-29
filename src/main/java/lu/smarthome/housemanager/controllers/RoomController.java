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
        return roomService.createOrUpdate(room);
    }

    @RequestMapping("{id}")
    public Room findById(@PathVariable Long id) {
        return roomService.findById(id);
    }

    @PutMapping("{id}")
    public Room updateById(@PathVariable Long id, @RequestBody Room room) {
        return roomService.updateById(id, room);
    }

    @DeleteMapping(value = "{id}")
    public void deleteById(@PathVariable Long id) {
        roomService.deleteById(id);
    }
}
