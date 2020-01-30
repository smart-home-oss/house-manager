package lu.smarthome.housemanager.controllers;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.domain.Device;
import lu.smarthome.housemanager.services.DeviceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.version.v1}/devices")
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping
    public Device create(@RequestBody Device device) {
        return deviceService.create(device);
    }

    @GetMapping("{id}")
    public Device show(@PathVariable Long id) {
        return deviceService.read(id);
    }

    @PutMapping("{id}")
    public Device update(@PathVariable Long id, @RequestBody Device device) {
        return deviceService.update(id, device);
    }

    @DeleteMapping(value = "{id}")
    public void destroy(@PathVariable Long id) {
        deviceService.delete(id);
    }
}
