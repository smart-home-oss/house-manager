package lu.smarthome.housemanager.houses.controller;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.domain.House;
import lu.smarthome.housemanager.houses.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.version.v1}/houses")
@CrossOrigin("${app.api.cors}")
public class HouseController {

    private final HouseService houseService;

    @PostMapping
    public House create(@RequestBody House house) {
        return houseService.createOrUpdate(house);
    }

    @GetMapping("{id}")
    public House read(@PathVariable Long id) {
        return houseService.read(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<House> readPaged(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "10") int size) {

        return houseService.readPaged(page, size);
    }

    @PutMapping("{id}")
    public House update(@PathVariable Long id, @RequestBody House house) {
        return houseService.update(id, house);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        houseService.delete(id);
    }

}
