package lu.smarthome.housemanager.houses.data;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "address", schema = "smarthome_housemanager")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String number;
    private String postCode;


}
