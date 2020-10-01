package lu.smarthome.housemanager.houses.data;

import lombok.*;
import lu.smarthome.housemanager.houses.exception.HouseValidationException;

import javax.persistence.*;

@Entity
@Table(name = "house", schema = "smarthome_housemanager")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class House {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    private Long addressId;

    public House update(House h) {
        if(h.name != null){
            name = h.name;
        }

        return this;
    }

    public House validToCreate() {
        if(name == null) {
            throw new HouseValidationException("Name of the house should be a non-empty string");
        }

        return this;
    }
}
