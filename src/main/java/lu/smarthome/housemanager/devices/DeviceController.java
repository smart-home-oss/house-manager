package lu.smarthome.housemanager.devices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.version.v1}/devices")
public class DeviceController {

    private final DeviceMapper mapper;
    private final DeviceService deviceService;

    @PostMapping
    public DeviceDTO create(@RequestBody DeviceDTO deviceDTO) {
        Device result = deviceService.create(mapper.toDevice(deviceDTO));

        return mapper.toDTO(result);
    }

    @GetMapping("{id}")
    public DeviceDTO read(@PathVariable Long id) {
        return mapper.toDTO(
                deviceService.read(id)
        );
    }

    @PutMapping("{id}")
    public DeviceDTO update(@PathVariable Long id, @RequestBody DeviceDTO deviceDTO) {

        return mapper.toDTO(
                deviceService.update(id, mapper.toDevice(deviceDTO))
        );
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        deviceService.delete(id);
    }
}
