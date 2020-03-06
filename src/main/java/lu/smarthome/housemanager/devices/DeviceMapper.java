package lu.smarthome.housemanager.devices;

import org.mapstruct.Mapper;

@Mapper
public interface DeviceMapper {

    DeviceDTO toDTO(Device device);
    Device toDevice(DeviceDTO deviceDTO);
}
