package lu.smarthome.housemanager.houses.api;

import lu.smarthome.housemanager.houses.data.House;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    HouseDTO toDTO(House house);

    House toHouse(HouseDTO dto);

    List<HouseDTO> toDTO(List<House> result);
}
