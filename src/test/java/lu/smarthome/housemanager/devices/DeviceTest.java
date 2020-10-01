package lu.smarthome.housemanager.devices;

import lu.smarthome.housemanager.devices.data.Device;
import lu.smarthome.housemanager.houses.exception.NoHousePieceAssignedDeviceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {

    @Test
    void validate() {
        Device device = new Device();

        assertThrows(BadDeviceNameException.class, device::validToCreate);

        device.setName("name");

        assertThrows(NoHousePieceAssignedDeviceException.class, device::validToCreate);

        device.setHousePieceId(Long.MAX_VALUE);

        assertDoesNotThrow(device::validToCreate);
    }

}