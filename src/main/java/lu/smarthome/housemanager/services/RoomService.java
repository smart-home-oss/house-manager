package lu.smarthome.housemanager.services;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.domain.Room;
import lu.smarthome.housemanager.exceptions.NoRoomFoundException;
import lu.smarthome.housemanager.repositories.RoomRepository;
import lu.smarthome.housemanager.validators.RoomValidator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomValidator roomValidator;

    public Room createOrUpdate(Room room) {
        roomValidator.validate(room);

        return roomRepository.save(room);
    }

    public Room updateById(Long id, Room room) {
        Room existingRoom = roomRepository
                .findById(id)
                .orElseThrow(() -> new NoRoomFoundException(id));

        if (room.getName() != null) {
            existingRoom.setName(room.getName());
        }

        if (room.getHouseId() != null) {
            existingRoom.setHouseId(room.getHouseId());
        }

        return createOrUpdate(room);
    }

    public Room findById(Long roomId) {
        return roomRepository
                .findById(roomId)
                .orElseThrow(() -> new NoRoomFoundException(roomId));
    }

    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }
}
