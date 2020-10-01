package lu.smarthome.housemanager.housespieces;

import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HousePieceService {

    private final HousePieceRepository repository;
    private final PageValidator        pageValidator;

    public Try<HousePiece> create(HousePiece r) {
        return Try
                .of(r::validBeforeCreation)
                .andThen(repository::save);
    }

    public Option<HousePiece> update(Long id, HousePiece housePiece) {
        return repository
                .vFindById(id)
                .map(h -> h.update(housePiece))
                .map(repository::vSave)
                .get();
    }

    public Option<HousePiece> read(Long roomId) {
        return repository.vFindById(roomId);
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

    public List<HousePiece> readPagedByHouseId(int pageNr, int size, long houseId) {
        pageValidator.validateForRead(pageNr, size);
        var page = PageRequest.of(pageNr, size);

        return repository
                .findAllByHouseId(houseId, page)
                .getContent();
    }
}
