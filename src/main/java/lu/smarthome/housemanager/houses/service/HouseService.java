package lu.smarthome.housemanager.houses.service;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.entity.House;
import lu.smarthome.housemanager.houses.exception.HouseNotFoundException;
import lu.smarthome.housemanager.houses.repository.HouseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository repository;

    public Try<House> create(House h) {
        return Try.of(h::validToCreate)
                .andThen(repository::save);
    }

    public Try<House> update(Long id, House h) {
        return Try.of(() -> repository.findById(id))
                .map(house -> house.orElseThrow(() -> new HouseNotFoundException(id)))
                .andThen(house -> house.update(h))
                .andThen(repository::save);
    }

    public Try<House> read(Long id) {
        return Try.of(() -> repository.findById(id))
                .map(house -> house.orElseThrow(() -> new HouseNotFoundException(id)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<House> readPaged(int pageNr, int size) {
        return repository
                .findAll(PageRequest.of(pageNr, size))
                .getContent();
    }
}
