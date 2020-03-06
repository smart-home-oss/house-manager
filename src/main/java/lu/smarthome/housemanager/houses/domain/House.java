package lu.smarthome.housemanager.houses.domain;

import lombok.*;

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
    private String street;
    private String number;
    private String postCode;
}
