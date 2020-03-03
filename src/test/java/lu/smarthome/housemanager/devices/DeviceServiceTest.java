package lu.smarthome.housemanager.devices;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeviceServiceTest {

    DeviceService service;
    DeviceRepository deviceRepository;

    @BeforeEach
    void setUp() {

        deviceRepository = mock(DeviceRepository.class);
        DeviceValidator deviceValidator = mock(DeviceValidator.class);

        service = new DeviceService(deviceRepository, deviceValidator);
    }

    @Test
    void create() {
        Device device = new Device();
        device.setName("name");
        device.setIcon("some Icon");
        device.setStatus(Long.MAX_VALUE);
        device.setRoomId(Long.MAX_VALUE);

        assertDoesNotThrow(() -> service.create(device));
    }

    @Test
    void read() {
        when(deviceRepository.findById(Long.MAX_VALUE))
                .thenReturn(Optional.of(mock(Device.class)));

        Device device = service.read(Long.MAX_VALUE);
        assertNotNull(device);
    }
}
