package lu.smarthome.housemanager.housespieces.data;

import io.vavr.control.Option;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousePieceRepository extends PagingAndSortingRepository<HousePiece, Long> {

    Page<HousePiece> findAllByHouseId(long houseId, Pageable pageable);

    default Option<HousePiece> vFindById(Long aLong) {
        return Option.ofOptional(findById(aLong));
    }
    default Option<HousePiece> vSave(HousePiece entity) {
        return Option.of(save(entity));
    };
}
