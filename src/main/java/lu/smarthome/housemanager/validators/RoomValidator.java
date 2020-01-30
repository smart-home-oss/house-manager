package lu.smarthome.housemanager.validators;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.domain.Room;
import lu.smarthome.housemanager.exceptions.BadPageException;
import lu.smarthome.housemanager.exceptions.BadRoomNameException;
import lu.smarthome.housemanager.exceptions.NoHouseAssignedRoomException;
import lu.smarthome.housemanager.params.RoomProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomValidator {

    private final RoomProperties roomProperties;

    public void validate(Room room) {
        if (room.getName() == null) {
            throw new BadRoomNameException("Name of the room cannot be null");
        }
        if (room.getHouseId() == null) {
            throw new NoHouseAssignedRoomException("This room has not been assigned to a house");
        }
    }

    public void validatePageParams(int page, int size) {
        if(page < 0) {
            throw new BadPageException("Page number should be equal or bigger than zero, page: " + page);
        }

        if(size < 0) {
            throw new BadPageException("Page size should be equal or bigger than zero, size: " + size);
        }

        if(size > roomProperties.getPageMaxSize()) {
            throw new BadPageException("Page size should be equal or bigger than zero, size: " + size);
        }
    }
}
