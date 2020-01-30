package lu.smarthome.housemanager.devices;

import lu.smarthome.housemanager.houses.exception.NoRoomAssignedDeviceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DeviceValidatorTest {

    private DeviceValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DeviceValidator();
    }

    @Test
    void validate() {
        Device device = new Device();

        assertThrows(BadDeviceNameException.class, () -> validator.validate(device));

        device.setName("name");

        assertThrows(NoRoomAssignedDeviceException.class, () -> validator.validate(device));

        device.setRoomId(Long.MAX_VALUE);

        assertDoesNotThrow(() -> validator.validate(device));
    }
}