package lu.smarthome.housemanager.houses.data;

import lu.smarthome.housemanager.houses.data.House;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends PagingAndSortingRepository<House, Long> {

}
