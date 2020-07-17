package lu.smarthome.housemanager.houses.service;

import lombok.RequiredArgsConstructor;
import lu.smarthome.housemanager.houses.entity.House;
import lu.smarthome.housemanager.houses.exception.HouseNotFoundException;
import lu.smarthome.housemanager.houses.repository.HouseRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseService {

    private final HouseRepository repository;

    public House create(House h) {
        return repository.save(
                h.validToCreate()
        );
    }

    public House update(Long id, House h){
        return repository.save(
                repository
                        .findById(id)
                        .orElseThrow(() -> new HouseNotFoundException(id))
                        .update(h)
        );
    }

    // @PreAuthorize("hasRole('ROLE_ADMIN')") // won't work
    @PreAuthorize("hasRole('ROLE_USER')")
    public House read(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new HouseNotFoundException(id));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<House> readPaged(int pageNr, int size) {
        return repository
                .findAll(PageRequest.of(pageNr, size))
                .getContent();
    }
}
