package lu.smarthome.housemanager.core;

import io.vavr.jackson.datatype.VavrModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    VavrModule vavrModule() {
        return new VavrModule();
    }

}
