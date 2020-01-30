package lu.smarthome.housemanager.validators;

import lu.smarthome.housemanager.domain.Device;
import lu.smarthome.housemanager.exceptions.BadDeviceNameException;
import lu.smarthome.housemanager.exceptions.BadRoomNameException;
import lu.smarthome.housemanager.exceptions.NoRoomAssignedDeviceException;
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
