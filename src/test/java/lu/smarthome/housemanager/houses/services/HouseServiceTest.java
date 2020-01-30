package lu.smarthome.housemanager.houses.services;

import lu.smarthome.housemanager.houses.domain.House;
import lu.smarthome.housemanager.houses.exception.HouseNotFoundException;
import lu.smarthome.housemanager.houses.service.HouseService;
import lu.smarthome.housemanager.houses.repository.HouseRepository;
import lu.smarthome.housemanager.houses.validator.HouseValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class HouseServiceTest {

    private HouseService houseService;
    private HouseValidator houseValidator;
    private HouseRepository houseRepository;

    @BeforeEach
    void setUp() {
        houseValidator = Mockito.mock(HouseValidator.class);
        houseRepository = Mockito.mock(HouseRepository.class);

        houseService = new HouseService(houseValidator, houseRepository);
    }

    @Test
    void update() {
        House newHouse = House
                .builder()
                .name("name")
                .number("number")
                .postCode("postcode")
                .street("street")
                .build();

        House oldHouse = new House();

        when(houseRepository.findById(any())).thenAnswer(onMock -> Optional.of(oldHouse));
        when(houseRepository.save(any())).thenAnswer(onMock -> oldHouse);

        final House result = houseService.update(Long.MAX_VALUE, newHouse);

        assertNotNull(result);
        assertEquals(newHouse.getName(), result.getName());
        assertEquals(newHouse.getNumber(), result.getNumber());
        assertEquals(newHouse.getPostCode(), result.getPostCode());
        assertEquals(newHouse.getStreet(), result.getStreet());
    }

    @Test
    void updateHouseNotFound() {
        when(houseRepository.findById(any())).thenAnswer(onMock -> Optional.empty());

        assertThrows(HouseNotFoundException.class, () -> houseService.update(Long.MAX_VALUE, new House()));
    }

    @Test
    void readNotFound() {
        when(houseRepository.findById(any())).thenAnswer(onMock -> Optional.empty());
        assertThrows(HouseNotFoundException.class, () -> houseService.read(Long.MAX_VALUE));
    }

    @Test
    void read() {
        House h = new House();
        when(houseRepository.findById(any())).thenAnswer(onMock -> Optional.of(h));

        assertEquals(h, houseService.read(Long.MAX_VALUE));
    }
}