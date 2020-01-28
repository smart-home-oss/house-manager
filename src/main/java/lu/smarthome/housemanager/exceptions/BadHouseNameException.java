package lu.smarthome.housemanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadHouseNameException extends RuntimeException {

    public BadHouseNameException(String message) {
        super(message);
    }
}
