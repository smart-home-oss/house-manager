package lu.smarthome.housemanager.houses.exception;

import lu.smarthome.common.exceptions.ExceptionDetail;
import lu.smarthome.common.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class NoDeviceFoundException extends NotFoundException {

    public NoDeviceFoundException(Long id) {
        super(ExceptionDetail.builder().message("Device not found, id: " + id).build());
    }
}
