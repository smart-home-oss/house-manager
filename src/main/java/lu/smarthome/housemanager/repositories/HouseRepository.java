package lu.smarthome.housemanager.repositories;

import lu.smarthome.housemanager.domain.House;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends PagingAndSortingRepository<House, Long> {

}
