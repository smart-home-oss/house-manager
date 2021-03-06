package lu.smarthome.housemanager.devices.api;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.devices.data.Device;
import lu.smarthome.housemanager.devices.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("${app.api.version.v1}/devices")
public class DeviceController {

    private final DeviceMapper  mapper;
    private final DeviceService deviceService;

    @PostMapping
    @ResponseStatus(CREATED)
    public DeviceDTO register(@RequestBody DeviceRegistrationDTO dto) {
        return mapper.toDTO(
                deviceService.create(mapper.toDevice(dto))
        );
    }

    @GetMapping
    public List<DeviceDTO> readAll(@RequestParam(required = false, defaultValue = "false") boolean unassigned) {
        List<DeviceDTO> result = new ArrayList<>();
        Iterable<Device> devices;

        if(unassigned) {
            devices = deviceService.readAllUnassigned();
        } else {
            devices = deviceService.readAll();
        }

        devices.forEach(d -> result.add(mapper.toDTO(d)));

        return result;
    }

    @GetMapping("{id}")
    public DeviceDTO read(@PathVariable Long id) {
        return mapper.toDTO(
                deviceService.read(id)
        );
    }

    @GetMapping("statuses")
    public Device.Status[] read() {
        return Device.Status.values();
    }

    @PutMapping("{id}")
    public DeviceDTO update(@PathVariable Long id, @RequestBody DeviceDTO dto) {
        return mapper.toDTO(
                deviceService.update(id, mapper.toDevice(dto))
        );
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        deviceService.delete(id);
    }
}
