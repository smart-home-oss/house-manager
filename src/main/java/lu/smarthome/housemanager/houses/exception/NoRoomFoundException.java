package lu.smarthome.housemanager.houses.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoRoomFoundException extends RuntimeException {

    public NoRoomFoundException(long roomId) {
        super("Room not found, roomId: " + roomId);
    }
}
