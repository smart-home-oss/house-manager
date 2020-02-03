package lu.smarthome.housemanager.houses.validators;

import lu.smarthome.housemanager.houses.domain.House;
import lu.smarthome.housemanager.houses.exception.HouseValidationException;
import lu.smarthome.housemanager.houses.validator.HouseValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseValidatorTest {

    private HouseValidator validator;

    @BeforeEach
    void setUp() {
        validator = new HouseValidator();
    }

    @Test
    void validate() {
        House house = new House();

        assertThrows(HouseValidationException.class, () -> validator.validate(house));

        house.setName("name");
        assertThrows(HouseValidationException.class, () -> validator.validate(house));

        house.setPostCode("post code");
        assertThrows(HouseValidationException.class, () -> validator.validate(house));

        house.setStreet("street");
        assertThrows(HouseValidationException.class, () -> validator.validate(house));

        house.setNumber("number"); // by this time all the fields should be fine
        assertDoesNotThrow(() -> validator.validate(house));
    }
}