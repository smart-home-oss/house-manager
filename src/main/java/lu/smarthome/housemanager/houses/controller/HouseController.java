package lu.smarthome.housemanager.houses.controller;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.HouseMapper;
import lu.smarthome.housemanager.houses.domain.House;
import lu.smarthome.housemanager.houses.dto.HouseDTO;
import lu.smarthome.housemanager.houses.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.version.v1}/houses")
@CrossOrigin("${app.api.cors}")
public class HouseController {

    private final HouseMapper mapper;
    private final HouseService houseService;

    @PostMapping
    public House create(@RequestBody HouseDTO dto) {
        return houseService.createOrUpdate(mapper.toHouse(dto));
    }

    @GetMapping("{id}")
    public HouseDTO read(@PathVariable Long id) {
        final House result = houseService.read(id);
        return mapper.toDTO(result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<HouseDTO> readPaged(@RequestParam(required = false, defaultValue = "0") int page,
                                    @RequestParam(required = false, defaultValue = "10") int size) {

        final List<House> result = houseService.readPaged(page, size);
        return mapper.toDTO(result);
    }

    @PutMapping("{id}")
    public HouseDTO update(@PathVariable Long id, @RequestBody HouseDTO dto) {
        final House result = houseService.update(id, mapper.toHouse(dto));
        return mapper.toDTO(result);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        houseService.delete(id);
    }

}
