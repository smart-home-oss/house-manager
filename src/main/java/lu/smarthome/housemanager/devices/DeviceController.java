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
    public DeviceDTO create(@RequestBody DeviceDTO dto) {
        final Device result = deviceService.create(mapper.toDevice(dto));
        return mapper.toDTO(result);
    }

    @GetMapping("{id}")
    public DeviceDTO read(@PathVariable Long id) {
        final Device result = deviceService.read(id);
        return mapper.toDTO(result);
    }

    @PutMapping("{id}")
    public DeviceDTO update(@PathVariable Long id, @RequestBody DeviceDTO dto) {
        final Device result = deviceService.update(id, mapper.toDevice(dto));
        return mapper.toDTO(result);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        deviceService.delete(id);
    }
}
