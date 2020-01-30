package lu.smarthome.housemanager.validators;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.domain.Room;
import lu.smarthome.housemanager.exceptions.BadPageException;
import lu.smarthome.housemanager.exceptions.BadPageSizeException;
import lu.smarthome.housemanager.exceptions.BadRoomNameException;
import lu.smarthome.housemanager.exceptions.BadHouseIdException;
import lu.smarthome.housemanager.params.RoomProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomValidator {
  
    private final RoomProperties roomProperties;

    public void validate(Room room) {
        if (room.getName() == null) {
            throw new BadRoomNameException("Name of the room should be a non-empty string");
        }

        if (room.getHouseId() == null || room.getHouseId() < 0) {
            throw new BadHouseIdException("The house should have a value bigger than ZERO, house id: " + room.getHouseId());
        }
    }

    public void validatePageParams(int page, int size) {
        if(page < 0) {
            throw new BadPageException("Page number should be equal or bigger than zero, page: " + page);
        }

        if(size < 0) {
            throw new BadPageSizeException("Page size should be equal or bigger than zero, size: " + size);
        }

        if(size > roomProperties.getPageMaxSize()) {
            throw new BadPageSizeException("Page size should be equal or bigger than zero, size: " + size);
        }
    }
}
