package lu.smarthome.housemanager.devices.api;

import lombok.Getter;
import lombok.Setter;
import lu.smarthome.housemanager.devices.data.Device;

@Getter
@Setter
public class DeviceDTO {
    private Long          id;
    private Long          roomId;
    private String        name;
    private String        icon;
    private Device.Status status;
}
