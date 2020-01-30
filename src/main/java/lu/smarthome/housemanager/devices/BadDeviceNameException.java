package lu.smarthome.housemanager.devices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadDeviceNameException extends RuntimeException {

    public BadDeviceNameException(String message) {
        super(message);
    }
}
