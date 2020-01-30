package lu.smarthome.housemanager.devices;


import lu.smarthome.housemanager.devices.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<Device, Long> {
}
