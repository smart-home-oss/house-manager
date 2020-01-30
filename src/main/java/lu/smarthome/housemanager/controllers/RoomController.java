package lu.smarthome.housemanager.controllers;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.domain.Room;
import lu.smarthome.housemanager.services.RoomService;
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
    public Room findById(@PathVariable Long id) {
        return roomService.findById(id);
    }

    @GetMapping("{id}")
    public Room show(@PathVariable Long id) {
        return roomService.read(id);

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<Room> findByPage(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "10") int size,
                                  @RequestParam(required = false) Long houseId) {

        if(houseId == null) {
            return roomService.getPage(page, size);
        } else {
            return roomService.getPageByHouseId(houseId, page, size);
        }
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
