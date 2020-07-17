package lu.smarthome.housemanager.devices;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceDTO {
    private Long          id;
    private Long          roomId;
    private String        name;
    private String        icon;
    private Device.Status status;
}
