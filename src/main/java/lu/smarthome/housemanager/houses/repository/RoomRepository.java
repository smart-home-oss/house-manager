package lu.smarthome.housemanager.houses.repository;


import lu.smarthome.housemanager.houses.entity.HousePiece;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends PagingAndSortingRepository<HousePiece, Long> {

    Page<HousePiece> findAllByHouseId(long houseId, Pageable pageable);

}
