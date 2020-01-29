package lu.smarthome.housemanager.controllers;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.domain.House;
import lu.smarthome.housemanager.services.HouseService;
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

    @GetMapping(path = "{id}")
    public House findById(@PathVariable Long id) {
        return houseService.getHouseById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<House> findByPage(@RequestParam(required = false, defaultValue = "0") int page,
                                  @RequestParam(required = false, defaultValue = "10") int size) {

        return houseService.getHouses(page, size);
    }

    @PutMapping(path = "{id}")
    public House updateById(@PathVariable Long id, @RequestBody House house) {
        return houseService.updateHouseById(id, house);
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable Long id){
        houseService.deleteHouseById(id);
    }

}
