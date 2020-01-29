package lu.smarthome.housemanager.services;

import lu.smarthome.housemanager.domain.House;
import lu.smarthome.housemanager.repositories.HouseRepository;
import lu.smarthome.housemanager.validators.HouseValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
    void create() {
        House house = new House();

        when(houseRepository.save(any())).thenAnswer(invocationOnMock -> {
            house.setId(Long.MAX_VALUE);
            return house;
        });

        final House result = houseService.createOrUpdate(house);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(house.getName(), result.getName());
    }
}