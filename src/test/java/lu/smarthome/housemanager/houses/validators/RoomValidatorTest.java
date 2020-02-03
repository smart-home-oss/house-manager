package lu.smarthome.housemanager.houses.validators;

import lu.smarthome.housemanager.houses.domain.Room;
import lu.smarthome.housemanager.houses.exception.BadHouseIdException;
import lu.smarthome.housemanager.houses.exception.BadPageException;
import lu.smarthome.housemanager.houses.exception.BadPageSizeException;
import lu.smarthome.housemanager.houses.exception.RoomValidationException;
import lu.smarthome.housemanager.houses.RoomProperties;
import lu.smarthome.housemanager.houses.validator.RoomValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoomValidatorTest {

    private RoomValidator validator;
    private RoomProperties properties = new RoomProperties();

    @BeforeEach
    void setUp() {
        properties.setPageMaxSize(BigInteger.TEN.intValue());

        validator = new RoomValidator(properties);
    }

    @Test
    void validate() {
        Room room = new Room();
        room.setHouseId(Long.MAX_VALUE);
        room.setName("name");

        assertDoesNotThrow(() -> validator.validate(room));
    }

    @Test
    void validateExceptions() {
        Room room = new Room();

        assertThrows(RoomValidationException.class, () -> validator.validate(room));

        room.setName("name");
        assertThrows(BadHouseIdException.class, () -> validator.validate(room));

        room.setHouseId(Long.MIN_VALUE);
        assertThrows(BadHouseIdException.class, () -> validator.validate(room));

    }

    @Test
    void validatePageParams() {
        assertDoesNotThrow(() -> validator.validatePageParams(1, properties.getPageMaxSize() - 1));
        assertThrows(BadPageSizeException.class,
                () -> validator.validatePageParams(1, properties.getPageMaxSize() + 1));

        assertThrows(BadPageException.class,
                () -> validator.validatePageParams(-1, properties.getPageMaxSize()));
    }
}