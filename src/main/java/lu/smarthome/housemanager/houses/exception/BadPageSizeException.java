package lu.smarthome.housemanager.houses.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadPageSizeException extends RuntimeException {

    public BadPageSizeException(String s) {
        super(s);
    }
}
