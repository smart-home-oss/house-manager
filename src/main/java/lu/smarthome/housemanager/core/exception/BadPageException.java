package lu.smarthome.housemanager.core.exception;

import lu.smarthome.common.exceptions.BadRequestException;
import lu.smarthome.common.exceptions.ExceptionDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadPageException extends BadRequestException {

    public BadPageException(String s) {
        super(ExceptionDetail.builder().message(s).build());
    }
}
