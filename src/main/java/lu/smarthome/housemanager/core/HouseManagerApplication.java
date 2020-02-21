package lu.smarthome.housemanager.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class HouseManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseManagerApplication.class, args);
	}

}
