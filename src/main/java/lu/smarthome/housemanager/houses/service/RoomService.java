package lu.smarthome.housemanager.houses.service;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.entity.HousePiece;
import lu.smarthome.housemanager.houses.exception.NoRoomFoundException;
import lu.smarthome.housemanager.houses.repository.RoomRepository;
import lu.smarthome.housemanager.houses.validator.PageValidator;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository repository;
    private final PageValidator  pageValidator;

    public HousePiece create(HousePiece r) {
        return repository.save(
                r.validToCreate()
        );
    }

    public HousePiece update(Long id, HousePiece housePiece) {
        return repository.save(
                repository
                        .findById(id)
                        .orElseThrow(() -> new NoRoomFoundException(id))
                        .update(housePiece)
        );
    }

    public HousePiece read(Long roomId) {
        return repository
                .findById(roomId)
                .orElseThrow(() -> new NoRoomFoundException(roomId));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<HousePiece> readPaged(int page, int size) {
        pageValidator.validateForRead(page, size);

        return repository
                .findAll(PageRequest.of(page, size))
                .getContent();
    }

    public List<HousePiece> readPagedByHouseId(int page, int size, long houseId) {
        pageValidator.validateForRead(page, size);

        return repository
                .findAllByHouseId(houseId, PageRequest.of(page, size))
                .getContent();
    }
}
