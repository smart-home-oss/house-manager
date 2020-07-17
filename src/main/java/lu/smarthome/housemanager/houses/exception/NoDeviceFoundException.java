package lu.smarthome.housemanager.houses.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class NoDeviceFoundException extends RuntimeException {

    public NoDeviceFoundException(Long id) {
        super("Device not found, id: " + id);
    }
}
