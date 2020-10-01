package lu.smarthome.housemanager.housespieces.api;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.housespieces.data.HousePiece;
import lu.smarthome.housemanager.housespieces.HousePieceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.version.v1}/house-piece")
@CrossOrigin("${app.api.cors}")
public class HousePieceController {

    private final HousePieceService service;
    private final HousePieceMapper  mapper;

    @PostMapping
    @ResponseStatus(CREATED)
    public HousePieceDTO create(@RequestBody HousePieceDTO dto) {
        return service
                .create(mapper.toRoom(dto))
                .map(mapper::toDTO)
                .get();
    }

    @GetMapping("types")
    public HousePiece.Type[] read() {
        return HousePiece.Type.values();
    }

    @GetMapping("{id}")
    public HousePieceDTO read(@PathVariable Long id) {
        return service
                .read(id)
                .map(mapper::toDTO)
                .get();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<HousePieceDTO> readPaged(@RequestParam(required = false, defaultValue = "0") int page,
                                         @RequestParam(required = false, defaultValue = "10") int size,
                                         @RequestParam(required = false) Long houseId) { // TODO, see if Optional can be used

        final List<HousePiece> result;

        if (houseId == null) {
            result = service.readPaged(page, size);
        } else {
            result = service.readPagedByHouseId(page, size, houseId);
        }

        return mapper.toRoomDTO(result);
    }

    @PutMapping("{id}")
    public HousePieceDTO update(@PathVariable Long id, @RequestBody HousePieceDTO dto) {
        return service
                .update(id, mapper.toRoom(dto))
                .map(mapper::toDTO)
                .get();
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
