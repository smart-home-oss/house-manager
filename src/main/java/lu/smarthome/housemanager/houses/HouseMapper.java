package lu.smarthome.housemanager.houses;

import lu.smarthome.housemanager.houses.domain.House;
import lu.smarthome.housemanager.houses.domain.Room;
import lu.smarthome.housemanager.houses.dto.HouseDTO;
import lu.smarthome.housemanager.houses.dto.RoomDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {

    HouseDTO toDTO(House house);
    RoomDTO toDTO(Room room);

    House toHouse(HouseDTO dto);
    Room toRoom(RoomDTO dto);

    List<HouseDTO> toDTO(List<House> result);

    List<RoomDTO> toRoomDTO(List<Room> result);
}
