package lu.smarthome.housemanager.houses.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lu.smarthome.housemanager.houses.entity.House;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = {"test"})
class HouseControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private JwtDecoder jwtDecoder;

    @Test
    void create() throws Exception {
        House newHouse = new House();
        newHouse.setName("my house");

        mvc.perform(
                post("/api/v1/houses")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(newHouse)))
                .andExpect(
                        status()
                                .is(HttpStatus.BAD_REQUEST.value()));
    }
}