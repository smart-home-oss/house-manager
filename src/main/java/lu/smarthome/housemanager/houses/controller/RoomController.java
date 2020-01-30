package lu.smarthome.housemanager.houses.controller;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.service.RoomService;
import lu.smarthome.housemanager.houses.domain.Room;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public Room read(@PathVariable Long id) {
        return roomService.read(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<Room> readPaged(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "10") int size,
                                  @RequestParam(required = false) Long houseId) {

        if(houseId == null) {
            return roomService.readPaged(page, size);
        } else {
            return roomService.readPagedByHouseId(page, size, houseId);
        }
    }

    @PutMapping("{id}")
    public Room update(@PathVariable Long id, @RequestBody Room room) {
        return roomService.update(id, room);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }
}
