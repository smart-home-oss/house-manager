package lu.smarthome.housemanager.housespieces.api;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class HousePieceDTO {

    private Long id;
    private Long houseId;
    private String name;

}
