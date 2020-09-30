package lu.smarthome.housemanager.devices;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceRegistrationDTO {
    private String name;
    private String ip;
    private Device.Type type;
    private int port;
}
