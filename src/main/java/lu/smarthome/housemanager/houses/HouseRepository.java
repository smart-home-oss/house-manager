package lu.smarthome.housemanager.houses;

import lu.smarthome.housemanager.houses.entity.House;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends PagingAndSortingRepository<House, Long> {

}
