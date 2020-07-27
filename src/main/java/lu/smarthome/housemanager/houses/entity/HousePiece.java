package lu.smarthome.housemanager.houses.entity;

import lombok.Getter;
import lombok.Setter;
import lu.smarthome.housemanager.houses.exception.RoomValidationException;

import javax.persistence.*;

import static lu.smarthome.housemanager.houses.entity.HousePiece.Type.ROOM;

@Entity
@Table(name = "house_piece", schema = "smarthome_housemanager")
@Getter
@Setter
public class HousePiece {
    public enum Type {
        ROOM, YARD, DRIVE_WAY, LIVING_ROOM, BATH_ROOM, WC, BED_ROOM, CLOSET, HALL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private Long   houseId;
    private String name;

    private HousePiece.Type type = ROOM;

    public HousePiece update(HousePiece r) {
        if (r.name != null) {
            name = r.name;
        }

        if (r.houseId != null) {
            houseId = r.houseId;
        }

        if (r.type != null) {
            type = r.type;
        }

        return this;
    }

    public HousePiece validBeforeCreation() {
        if (name == null) {
            throw new RoomValidationException("Name of the room should be a non-empty string");
        }

        if (houseId == null || houseId < 1) {
            throw new RoomValidationException("The house id should have a value bigger than ZERO");
        }

        return this;
    }
}
