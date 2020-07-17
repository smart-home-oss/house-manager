package lu.smarthome.housemanager.houses;

import lu.smarthome.housemanager.houses.entity.House;
import lu.smarthome.housemanager.houses.entity.HousePiece;
import lu.smarthome.housemanager.houses.dto.HouseDTO;
import lu.smarthome.housemanager.houses.dto.RoomDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    HouseDTO toDTO(House house);
    RoomDTO toDTO(HousePiece housePiece);

    House toHouse(HouseDTO dto);
    HousePiece toRoom(RoomDTO dto);

    List<HouseDTO> toDTO(List<House> result);

    List<RoomDTO> toRoomDTO(List<HousePiece> result);
}
