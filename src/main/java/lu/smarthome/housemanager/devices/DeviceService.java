package lu.smarthome.housemanager.devices;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.exception.NoDeviceFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceValidator deviceValidator;

    public Device create(Device device) {
        deviceValidator.validate(device);

        return deviceRepository.save(device);
    }

    public Device read(Long deviceId) throws NoDeviceFoundException {
        return deviceRepository.findById(deviceId).orElseThrow(() -> new NoDeviceFoundException("No device found with Id " + deviceId));
    }

    public Device update(Long id, Device device) {
        Device existingDevice = deviceRepository.findById(id).orElseThrow(() -> new NoDeviceFoundException("No device found with Id " + id));

        if (device.getName() != null) {
            existingDevice.setName(device.getName());
        }

        if (device.getRoomId() != null) {
            existingDevice.setRoomId(device.getRoomId());
        }

        if (device.getIcon() != null) {
            existingDevice.setIcon(device.getIcon());
        }

        if (device.getStatus() != null) {
            existingDevice.setStatus(device.getStatus());
        }

        return deviceRepository.save(existingDevice);
    }

    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }
}
