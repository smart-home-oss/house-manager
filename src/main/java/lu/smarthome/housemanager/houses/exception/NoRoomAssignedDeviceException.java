package lu.smarthome.housemanager.houses.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoRoomAssignedDeviceException extends RuntimeException {

    public NoRoomAssignedDeviceException(String message) {
        super(message);
    }
}
