package lu.smarthome.housemanager.devices;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.devices.data.Device;
import lu.smarthome.housemanager.devices.data.DeviceRepository;
import lu.smarthome.housemanager.houses.exception.NoDeviceFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public Device create(Device device) {
        return deviceRepository.save(
                device.validToCreate()
        );
    }

    public Device read(Long id) {
        return deviceRepository
                .findById(id)
                .orElseThrow(() -> new NoDeviceFoundException(id));
    }

    public Iterable<Device> readAll() {
        return deviceRepository.findAll();
    }

    public Device update(Long id, Device d) {
        return deviceRepository.save(
                deviceRepository
                        .findById(id)
                        .orElseThrow(() -> new NoDeviceFoundException(id))
                        .update(d)
        );
    }

    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }

    public Iterable<Device> readAllUnassigned() {
        return deviceRepository.findAllByHousePieceIdIsNull();
    }
}
