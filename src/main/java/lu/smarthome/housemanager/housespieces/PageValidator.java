package lu.smarthome.housemanager.housespieces;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.core.exception.BadPageException;
import lu.smarthome.housemanager.core.exception.BadPageSizeException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageValidator {
  
    private final HousePieceProperties housePieceProperties;

    public void validateForRead(int page, int size) {
        if(page < 0) {
            throw new BadPageException("Page number should be equal or bigger than zero, page: " + page);
        }

        if(size < 0) {
            throw new BadPageSizeException("Page size should be equal or bigger than zero, size: " + size);
        }

        if(size > housePieceProperties.getPageMaxSize()) {
            throw new BadPageSizeException("Page size should be equal or smaller, " +
                    "max size: " + housePieceProperties.getPageMaxSize()+
                    "size: " + size);
        }
    }
}
