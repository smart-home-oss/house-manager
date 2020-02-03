package lu.smarthome.housemanager.houses.validator;

import lu.smarthome.housemanager.houses.domain.House;
import lu.smarthome.housemanager.houses.exception.HouseValidationException;
import org.springframework.stereotype.Component;

@Component
public class HouseValidator {

    public void validate(House house) {
        if(house.getName() == null) {
            throw new HouseValidationException("Name of the house should be a non-empty string");
        }

        if(house.getNumber() == null) {
            throw new HouseValidationException("Number of the house should be a non-empty string");
        }

        if(house.getPostCode() == null) {
            throw new HouseValidationException("Post code of the house should be a non-empty string");
        }

        if(house.getStreet() == null) {
            throw new HouseValidationException("Street of the house should be a non-empty string");
        }
    }

}
