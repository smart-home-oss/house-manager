package lu.smarthome.housemanager.houses;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.version.v1}/houses")
@CrossOrigin("${app.api.cors}")
public class HouseController {

    private final HouseMapper  mapper;
    private final HouseService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public HouseDTO create(@RequestBody HouseDTO dto) {
        return Try.of(() -> mapper.toHouse(dto))
                .andThen(service::create)
                .map(mapper::toDTO)
                .get();
    }

    @GetMapping("{id}")
    public HouseDTO read(@PathVariable Long id) {
        return service.read(id)
                .map(mapper::toDTO)
                .get();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<HouseDTO> readPaged(@RequestParam(required = false, defaultValue = "0") int pageNr,
                                    @RequestParam(required = false, defaultValue = "10") int size) {

        return Try.of(() -> service.readPaged(pageNr, size))
                .map(mapper::toDTO)
                .get();
    }

    @PutMapping("{id}")
    public HouseDTO update(@PathVariable Long id, @RequestBody HouseDTO dto) {
        return service.update(id, mapper.toHouse(dto))
                .map(mapper::toDTO)
                .get();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
