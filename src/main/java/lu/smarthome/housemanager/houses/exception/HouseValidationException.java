package lu.smarthome.housemanager.houses.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HouseValidationException extends RuntimeException {

    public HouseValidationException(String message) {
        super(message);
    }
}
