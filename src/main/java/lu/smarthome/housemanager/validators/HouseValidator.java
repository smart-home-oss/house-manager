package lu.smarthome.housemanager.validators;

import lu.smarthome.housemanager.domain.House;
import lu.smarthome.housemanager.exceptions.BadHouseNameException;
import org.springframework.stereotype.Component;

@Component
public class HouseValidator {

    public void validate(House house) {
        if(house.getName() == null) {
            throw new BadHouseNameException("Name of the house cannot be null");
        }
    }

}
