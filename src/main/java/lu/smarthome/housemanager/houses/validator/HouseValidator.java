package lu.smarthome.housemanager.houses.validator;

import lu.smarthome.housemanager.houses.domain.House;
import lu.smarthome.housemanager.houses.exception.BadHouseException;
import org.springframework.stereotype.Component;

@Component
public class HouseValidator {

    public void validate(House house) {
        if(house.getName() == null) {
            throw new BadHouseException("Name of the house should be a non-empty string");
        }

        if(house.getNumber() == null) {
            throw new BadHouseException("Number of the house should be a non-empty string");
        }

        if(house.getPostCode() == null) {
            throw new BadHouseException("Post code of the house should be a non-empty string");
        }

        if(house.getStreet() == null) {
            throw new BadHouseException("Street of the house should be a non-empty string");
        }
    }

}