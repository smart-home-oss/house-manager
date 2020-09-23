package lu.smarthome.housemanager.houses.exception;

import lu.smarthome.common.exceptions.ExceptionDetail;
import lu.smarthome.common.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HouseNotFoundException extends NotFoundException {

    public HouseNotFoundException(long id) {
        super(ExceptionDetail.builder().message("House not found, id: " + id).build());
    }
}
