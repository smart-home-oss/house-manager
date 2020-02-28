package lu.smarthome.housemanager.houses.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "house", schema = "smarthome_housemanager")
@Getter
@Setter
public class Room {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long houseId;
    private String name;

}
