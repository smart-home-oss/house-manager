package lu.smarthome.housemanager.devices.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {

    Iterable<Device> findAllByHousePieceIdIsNull();
}
