package lu.smarthome.housemanager.devices.api;

import lu.smarthome.housemanager.devices.data.Device;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    DeviceDTO toDTO(Device device);
    Device toDevice(DeviceDTO dto);
    Device toDevice(DeviceRegistrationDTO dto);
}
