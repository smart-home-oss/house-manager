package lu.smarthome.housemanager.houses.service;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.validator.HouseValidator;
import lu.smarthome.housemanager.houses.domain.House;
import lu.smarthome.housemanager.houses.exception.HouseNotFoundException;
import lu.smarthome.housemanager.houses.repository.HouseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
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

    public House update(Long id, @NotNull House house){

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

    // @PreAuthorize("hasRole('ROLE_ADMIN')") // won't work
    @PreAuthorize("hasRole('ROLE_USER')")
    public House read(Long id) {
        return houseRepository
                .findById(id)
                .orElseThrow(() -> new HouseNotFoundException(id));
    }

    public void delete(Long id){
        houseRepository.deleteById(id);
    }

    public List<House> readPaged(int page, int size) {
        return houseRepository
                .findAll(PageRequest.of(page, size))
                .getContent();
    }
}
