package lu.smarthome.housemanager.devices;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    DeviceDTO toDTO(Device device);
    Device toDevice(DeviceDTO deviceDTO);
}
