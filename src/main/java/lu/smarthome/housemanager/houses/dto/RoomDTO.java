package lu.smarthome.housemanager.houses.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class RoomDTO {

    private Long id;
    private Long houseId;
    private String name;

}
