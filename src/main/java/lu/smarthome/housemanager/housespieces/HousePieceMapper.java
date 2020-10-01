package lu.smarthome.housemanager.housespieces;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HousePieceMapper {
    HousePieceDTO toDTO(HousePiece housePiece);
    HousePiece toRoom(HousePieceDTO dto);

    List<HousePieceDTO> toRoomDTO(List<HousePiece> result);
}
