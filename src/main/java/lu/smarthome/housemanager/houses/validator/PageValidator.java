package lu.smarthome.housemanager.houses.validator;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.RoomProperties;
import lu.smarthome.housemanager.houses.exception.BadPageException;
import lu.smarthome.housemanager.houses.exception.BadPageSizeException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageValidator {
  
    private final RoomProperties roomProperties;

    public void validateForRead(int page, int size) {
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
