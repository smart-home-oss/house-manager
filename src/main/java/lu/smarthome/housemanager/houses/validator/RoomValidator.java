package lu.smarthome.housemanager.houses.validator;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.RoomProperties;
import lu.smarthome.housemanager.houses.domain.Room;
import lu.smarthome.housemanager.houses.exception.BadPageException;
import lu.smarthome.housemanager.houses.exception.BadPageSizeException;
import lu.smarthome.housemanager.houses.exception.RoomValidationException;
import lu.smarthome.housemanager.houses.exception.BadHouseIdException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomValidator {
  
    private final RoomProperties roomProperties;

    public void validate(Room room) {
        if (room.getName() == null) {
            throw new RoomValidationException("Name of the room should be a non-empty string");
        }

        if (room.getHouseId() == null || room.getHouseId() < 1) {
            throw new RoomValidationException("The house id should have a value bigger than ZERO");
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
