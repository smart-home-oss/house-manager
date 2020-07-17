package lu.smarthome.housemanager.devices;

import lu.smarthome.housemanager.houses.exception.NoRoomAssignedDeviceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {

    @Test
    void validate() {
        Device device = new Device();

        assertThrows(BadDeviceNameException.class, device::validToCreate);

        device.setName("name");

        assertThrows(NoRoomAssignedDeviceException.class, device::validToCreate);

        device.setHousePieceId(Long.MAX_VALUE);

        assertDoesNotThrow(device::validToCreate);
    }

}