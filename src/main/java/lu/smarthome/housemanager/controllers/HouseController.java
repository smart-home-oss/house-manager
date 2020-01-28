package lu.smarthome.housemanager.controllers;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.domain.House;
import lu.smarthome.housemanager.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
        return houseService.create(house);
    }

    @GetMapping(path = "{id}")
    public House getHouseById(@PathVariable Long id) {
        return houseService.getHouseById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
    public List<House> getHouses(@RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "10") int size) {

        return houseService.getHouses(page, size);
    }

    @PutMapping(path = "{id}")
    public House updateHouseById(@PathVariable Long id, @RequestBody House house) {
        return houseService.updateHouseById(id, house);
    }

    @DeleteMapping(path = "{id}")
    public void deleteHouseById(@PathVariable Long id){
        houseService.deleteHouseById(id);
    }

}
