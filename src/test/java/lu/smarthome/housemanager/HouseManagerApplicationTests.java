package lu.smarthome.housemanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = {"test1"})
class HouseManagerApplicationTests {

    @Test
    void contextLoads() {
    }

}
