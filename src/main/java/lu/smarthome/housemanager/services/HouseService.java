package lu.smarthome.housemanager.services;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.domain.House;
import lu.smarthome.housemanager.exceptions.HouseNotFoundException;
import lu.smarthome.housemanager.repositories.HouseRepository;
import lu.smarthome.housemanager.validators.HouseValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseValidator houseValidator;
    private final HouseRepository houseRepository;

    public House create(House house) {
        houseValidator.validate(house);

        return houseRepository.save(house);
    }

    public House getHouseById(Long id) {
        return houseRepository.findById(id).orElseThrow(() -> new HouseNotFoundException("No house found with id: " + id));
    }

    public House updateHouseById(Long id, House house){

        House existingHouse = houseRepository.findById(id).get();

        if(existingHouse != null)
        {
            if(house.getName() != null){
                existingHouse.setName(house.getName());
            }
            else if(house.getNumber() != null){
                existingHouse.setNumber(house.getNumber());
            }
            else if (house.getPostCode() != null){
                existingHouse.setPostCode(house.getPostCode());
            }
            else if (house.getStreet() != null){
                existingHouse.setStreet(house.getStreet());
            }
            //update existing house
            return create(existingHouse);
        }
        //create a new house
        return create(house);
    }

    public void deleteHouseById(Long id){
        houseRepository.deleteById(id);
    }

    public List<House> getHouses(int page, int size) {
        final Page<House> result = houseRepository.findAll(PageRequest.of(page, size));

        return result.getContent();
    }
}
