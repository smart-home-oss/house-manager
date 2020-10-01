package lu.smarthome.housemanager.houses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {

    private Long id;
    private String name;
    private String street;
    private String number;
    private String postCode;
}
