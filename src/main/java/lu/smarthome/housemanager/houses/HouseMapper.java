package lu.smarthome.housemanager.houses;

import lu.smarthome.housemanager.houses.entity.House;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    HouseDTO toDTO(House house);

    House toHouse(HouseDTO dto);

    List<HouseDTO> toDTO(List<House> result);
}
