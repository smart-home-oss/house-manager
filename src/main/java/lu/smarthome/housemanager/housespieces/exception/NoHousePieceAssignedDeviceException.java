package lu.smarthome.housemanager.houses.exception;

import lu.smarthome.common.exceptions.BadRequestException;
import lu.smarthome.common.exceptions.ExceptionDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoHousePieceAssignedDeviceException extends BadRequestException {

    public NoHousePieceAssignedDeviceException(String m) {
        super(ExceptionDetail.builder().message(m).build());
    }
}
