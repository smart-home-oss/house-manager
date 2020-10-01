package lu.smarthome.housemanager.devices.api;

import lombok.Getter;
import lombok.Setter;
import lu.smarthome.housemanager.devices.data.Device;

@Getter
@Setter
public class DeviceRegistrationDTO {
    private String      name;
    private String      ip;
    private Device.Type type;
    private int         port;
}
