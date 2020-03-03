package lu.smarthome.housemanager.devices;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class DeviceServiceTest {

    private DeviceService service;

    @BeforeEach
    void setUp() {

        DeviceRepository deviceRepository = Mockito.mock(DeviceRepository.class);
        DeviceValidator deviceValidator = Mockito.mock(DeviceValidator.class);

        service = new DeviceService(deviceRepository, deviceValidator);
    }

    @Test
    void validate() {
        Device device = new Device();
        device.setName("name");
        device.setIcon("some Icon");
        device.setStatus(Long.MAX_VALUE);
        device.setRoomId(Long.MAX_VALUE);

        assertDoesNotThrow(() -> service.create(device));
    }
}
