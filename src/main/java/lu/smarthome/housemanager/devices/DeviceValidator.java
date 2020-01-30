package lu.smarthome.housemanager.devices;

import lu.smarthome.housemanager.houses.exception.NoRoomAssignedDeviceException;
import org.springframework.stereotype.Component;

@Component
public class DeviceValidator {

    public void validate(Device device) {
        if (device.getName() == null) {
            throw new BadDeviceNameException("Name should be a non-empty string");
        }

        if (device.getRoomId() == null || device.getRoomId() < 0) {
            throw new NoRoomAssignedDeviceException("The room id should be a value bigger than ZERO");
        }
    }
}
