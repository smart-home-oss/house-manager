package lu.smarthome.housemanager.houses.controller;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.HouseMapper;
import lu.smarthome.housemanager.houses.dto.RoomDTO;
import lu.smarthome.housemanager.houses.entity.HousePiece;
import lu.smarthome.housemanager.houses.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.version.v1}/rooms")
@CrossOrigin("${app.api.cors}")
public class RoomController {

    private final RoomService roomService;
    private final HouseMapper mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    public RoomDTO create(@RequestBody RoomDTO dto) {
        return mapper.toDTO(
                roomService.create(mapper.toRoom(dto))
        );
    }

    @GetMapping("{id}")
    public RoomDTO read(@PathVariable Long id) {
        return mapper.toDTO(
                roomService.read(id)
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<RoomDTO> readPaged(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "10") int size,
                                  @RequestParam(required = false) Long houseId) { // TODO, see if Optional can be used

        final List<HousePiece> result;

        if(houseId == null) {
            result = roomService.readPaged(page, size);
        } else {
            result = roomService.readPagedByHouseId(page, size, houseId);
        }

        return mapper.toRoomDTO(result);
    }

    @PutMapping("{id}")
    public RoomDTO update(@PathVariable Long id, @RequestBody RoomDTO dto) {
        return mapper.toDTO(
                roomService.update(id, mapper.toRoom(dto))
        );
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        roomService.delete(id);
    }
}
