package lu.smarthome.housemanager.houses.entities;

import lu.smarthome.housemanager.houses.model.House;
import lu.smarthome.housemanager.houses.exception.HouseValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HouseTest {

    @Test
    void validate() {
        House house = new House();

        assertThrows(HouseValidationException.class, house::validToCreate);

        house.setName("name");
        assertThrows(HouseValidationException.class, house::validToCreate);

        house.setAddressId(Long.MAX_VALUE);
        assertDoesNotThrow(house::validToCreate);
    }
}