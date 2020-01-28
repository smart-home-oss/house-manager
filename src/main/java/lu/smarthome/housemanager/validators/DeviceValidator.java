package lu.smarthome.housemanager.validators;

import lu.smarthome.housemanager.domain.Device;
import lu.smarthome.housemanager.exceptions.BadRoomNameException;
import lu.smarthome.housemanager.exceptions.NoRoomAssignedDeviceException;
import org.springframework.stereotype.Component;

@Component
public class DeviceValidator {
    private Device device;

    public void validate(Device device) {
        if (device.getName() == null) {
            throw new BadRoomNameException("Name of the device cannot be null");
        }
        if (device.getRoomId() == null) {
            throw new NoRoomAssignedDeviceException("This device has not been assigned to a room");
        }
    }
}
