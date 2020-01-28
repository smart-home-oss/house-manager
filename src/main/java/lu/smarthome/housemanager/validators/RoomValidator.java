package lu.smarthome.housemanager.validators;

import lu.smarthome.housemanager.domain.Room;
import lu.smarthome.housemanager.exceptions.BadRoomNameException;
import lu.smarthome.housemanager.exceptions.NoHouseAssignedRoomException;
import org.springframework.stereotype.Component;

@Component
public class RoomValidator {

    public void validate(Room room) {
        if (room.getName() == null) {
            throw new BadRoomNameException("Name of the room cannot be null");
        }
        if (room.getHouseId() == null) {
            throw new NoHouseAssignedRoomException("This room has not been assigned to a house");
        }
    }
}
