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

    public Room create(Room room) {
        roomValidator.validate(room);

        return roomRepository.save(room);
    }

    public Room read(Long roomId) throws NoRoomFoundException {
        return roomRepository.findById(roomId).orElseThrow(() -> new NoRoomFoundException("No room found with Id " + roomId));
    }

    public Room update(Long id, Room room) {
        Room existingRoom = roomRepository.findById(id).get();

        if (existingRoom != null) {

            if (room.getName() != null) {
                existingRoom.setName(room.getName());
            }

            if (room.getHouseId() != null) {
                existingRoom.setHouseId(room.getHouseId());
            }
            return roomRepository.save(existingRoom);
        }

        return roomRepository.save(room);
    }

    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}
