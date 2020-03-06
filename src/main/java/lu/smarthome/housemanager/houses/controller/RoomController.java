package lu.smarthome.housemanager.houses.controller;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.HouseMapper;
import lu.smarthome.housemanager.houses.dto.RoomDTO;
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
    private final HouseMapper mapper;

    @PostMapping
    public RoomDTO create(@RequestBody RoomDTO dto) {
        final Room result = roomService.createOrUpdate(mapper.toRoom(dto));
        return mapper.toDTO(result);
    }

    @GetMapping("{id}")
    public RoomDTO read(@PathVariable Long id) {
        final Room result = roomService.read(id);
        return mapper.toDTO(result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<RoomDTO> readPaged(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "10") int size,
                                  @RequestParam(required = false) Long houseId) {

        final List<Room> result;

        if(houseId == null) {
            result = roomService.readPaged(page, size);
        } else {
            result = roomService.readPagedByHouseId(page, size, houseId);
        }

        return mapper.toRoomDTO(result);
    }

    @PutMapping("{id}")
    public RoomDTO update(@PathVariable Long id, @RequestBody RoomDTO dto) {
        final Room result = roomService.update(id, mapper.toRoom(dto));
        return mapper.toDTO(result);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }
}
