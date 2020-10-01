package lu.smarthome.housemanager.houses.validators;

import lu.smarthome.housemanager.core.exception.BadPageException;
import lu.smarthome.housemanager.core.exception.BadPageSizeException;
import lu.smarthome.housemanager.housespieces.HousePieceProperties;
import lu.smarthome.housemanager.housespieces.PageValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PageValidatorTest {

    private       PageValidator        validator;
    private final HousePieceProperties properties = new HousePieceProperties();

    @BeforeEach
    void setUp() {
        properties.setPageMaxSize(BigInteger.TEN.intValue());
        validator = new PageValidator(properties);
    }



    @Test
    void validatePageParams() {
        assertDoesNotThrow(() -> validator.validateForRead(1, properties.getPageMaxSize() - 1));
        assertThrows(BadPageSizeException.class,
                () -> validator.validateForRead(1, properties.getPageMaxSize() + 1));

        assertThrows(BadPageException.class,
                () -> validator.validateForRead(-1, properties.getPageMaxSize()));
    }
}