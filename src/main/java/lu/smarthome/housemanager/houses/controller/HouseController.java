package lu.smarthome.housemanager.houses.controller;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.HouseMapper;
import lu.smarthome.housemanager.houses.dto.HouseDTO;
import lu.smarthome.housemanager.houses.service.HouseService;
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
        var house = service.create(
                mapper.toHouse(dto)
        );

        return mapper.toDTO(house);
    }

    @GetMapping("{id}")
    public HouseDTO read(@PathVariable Long id) {
        return mapper.toDTO(
                service.read(id)
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<HouseDTO> readPaged(@RequestParam(required = false, defaultValue = "0") int pageNr,
                                    @RequestParam(required = false, defaultValue = "10") int size) {
        return mapper.toDTO(
                service.readPaged(pageNr, size)
        );
    }

    @PutMapping("{id}")
    public HouseDTO update(@PathVariable Long id, @RequestBody HouseDTO dto) {
        return mapper.toDTO(
                service.update(id, mapper.toHouse(dto))
        );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
