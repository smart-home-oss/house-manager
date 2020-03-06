package lu.smarthome.housemanager.devices;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
public class DeviceDTO {
    private Long id;
    private Long roomId;
    private String name;
    private String icon;
    private Long status;
}
