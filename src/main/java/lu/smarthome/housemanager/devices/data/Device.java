package lu.smarthome.housemanager.devices.data;

import lombok.Getter;
import lombok.Setter;
import lu.smarthome.housemanager.devices.BadDeviceNameException;
import lu.smarthome.housemanager.houses.exception.NoHousePieceAssignedDeviceException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static lu.smarthome.housemanager.devices.data.Device.Status.NEW;
import static lu.smarthome.housemanager.devices.data.Device.Type.OTHER;

@Entity
@Getter
@Setter
public class Device {

    public enum Status {
        ON, OFF, CONFIGURED, NEW
    }

    public enum Type {
        SENSOR, CAMERA, OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private Long   housePieceId;
    private String name;
    private String icon;
    private Status status = NEW;

    private Type type = OTHER;

    public Device update(Device device) {
        if (device.name != null) {
            name = device.name;
        }

        if (device.housePieceId != null) {
            housePieceId = device.housePieceId;
        }

        if (device.icon != null) {
            icon = device.icon;
        }

        if (device.status != null) {
            status = device.status;
        }

        return this;
    }

    public Device validToCreate() {
        if (name == null) {
            throw new BadDeviceNameException("Name should be a non-empty string");
        }

        if (housePieceId == null || housePieceId < 0) {
            throw new NoHousePieceAssignedDeviceException("The room id should be a value bigger than ZERO");
        }

        return this;
    }
}
