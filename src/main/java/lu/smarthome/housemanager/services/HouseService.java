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

    public House createOrUpdate(House house) {
        houseValidator.validate(house);

        return houseRepository.save(house);
    }

    public House updateHouseById(Long id, House house){

        House existingHouse = houseRepository
                .findById(id)
                .orElseThrow(() -> new HouseNotFoundException(id));

        if(house.getName() != null){
            existingHouse.setName(house.getName());
        }

        if(house.getNumber() != null){
            existingHouse.setNumber(house.getNumber());
        }

        if (house.getPostCode() != null){
            existingHouse.setPostCode(house.getPostCode());
        }

        if (house.getStreet() != null){
            existingHouse.setStreet(house.getStreet());
        }

        return createOrUpdate(existingHouse);
    }

    public House getHouseById(Long id) {
        return houseRepository
                .findById(id)
                .orElseThrow(() -> new HouseNotFoundException(id));
    }

    public void deleteHouseById(Long id){
        houseRepository.deleteById(id);
    }

    public List<House> getPage(int page, int size) {
        return houseRepository
                .findAll(PageRequest.of(page, size))
                .getContent();
    }
}
