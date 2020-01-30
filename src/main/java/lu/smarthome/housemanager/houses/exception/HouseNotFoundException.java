package lu.smarthome.housemanager.houses.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HouseNotFoundException extends RuntimeException {

    public HouseNotFoundException(long id) {
        super("House not found, id: " + id);
    }
}
