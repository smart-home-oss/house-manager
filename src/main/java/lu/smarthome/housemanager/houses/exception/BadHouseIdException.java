package lu.smarthome.housemanager.houses.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadHouseIdException extends RuntimeException {

    public BadHouseIdException(String message) {
        super(message);
    }
}