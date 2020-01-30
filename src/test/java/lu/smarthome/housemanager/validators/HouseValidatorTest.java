package lu.smarthome.housemanager.validators;

import lu.smarthome.housemanager.houses.domain.House;
import lu.smarthome.housemanager.houses.exception.BadHouseException;
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

        assertThrows(BadHouseException.class, () -> validator.validate(house));

        house.setName("name");
        assertThrows(BadHouseException.class, () -> validator.validate(house));

        house.setPostCode("post code");
        assertThrows(BadHouseException.class, () -> validator.validate(house));

        house.setStreet("street");
        assertThrows(BadHouseException.class, () -> validator.validate(house));

        house.setNumber("number"); // by this time all the fields should be fine
        assertDoesNotThrow(() -> validator.validate(house));
    }
}