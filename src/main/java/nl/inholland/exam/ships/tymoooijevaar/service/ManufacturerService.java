package nl.inholland.exam.ships.tymoooijevaar.service;

import nl.inholland.exam.ships.tymoooijevaar.exception.ManufacturerExistsException;
import nl.inholland.exam.ships.tymoooijevaar.model.Manufacturer;
import nl.inholland.exam.ships.tymoooijevaar.model.dto.ManufacturerDTO;
import nl.inholland.exam.ships.tymoooijevaar.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    private final ManufacturerRepository repository;

    private ManufacturerService(ManufacturerRepository repository) {
        this.repository = repository;
    }

    public List<Manufacturer> getAllManufacturers() {
        return repository.findAll();
    }

    public List<Manufacturer> getAllManufacturersByAffiliation(String affiliation) {
        return repository.findAllByAffiliation(affiliation);
    }

    public Manufacturer addManufacturer(ManufacturerDTO dto) throws ManufacturerExistsException {
        if (repository.findByName(dto.getName()) != null)
            throw new ManufacturerExistsException();

        Manufacturer manufacturer = new Manufacturer(
                dto.getId(),
                dto.getName(),
                dto.getAffiliation(),
                dto.getCeo(),
                List.of()
        );

        return repository.save(manufacturer);
    }
}
