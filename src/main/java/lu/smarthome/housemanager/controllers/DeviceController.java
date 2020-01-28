package lu.smarthome.housemanager.controllers;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.domain.Device;
import lu.smarthome.housemanager.services.DeviceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.version.v1}/devices")
public class DeviceController {

    private final DeviceService DeviceService;

    @PostMapping
    public Device create(@RequestBody Device Device) {
        return DeviceService.create(Device);
    }

    @RequestMapping("{id}")
    public Device show(@PathVariable Long id) {
        return DeviceService.read(id);
    }

    @PutMapping("{id}")
    public Device update(@PathVariable Long id, @RequestBody Device Device) {
        return DeviceService.update(id, Device);
    }

    @DeleteMapping(value = "{id}")
    public void destroy(@PathVariable Long id) {
        DeviceService.delete(id);
    }
}
