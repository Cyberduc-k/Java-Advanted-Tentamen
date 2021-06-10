package nl.inholland.exam.ships.tymoooijevaar.service;

import nl.inholland.exam.ships.tymoooijevaar.model.Manufacturer;
import nl.inholland.exam.ships.tymoooijevaar.model.Ship;
import nl.inholland.exam.ships.tymoooijevaar.model.dto.ShipDTO;
import nl.inholland.exam.ships.tymoooijevaar.repository.ManufacturerRepository;
import nl.inholland.exam.ships.tymoooijevaar.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final ManufacturerRepository manufacturerRepository;

    private ShipService(ShipRepository shipRepository, ManufacturerRepository manufacturerRepository) {
        this.shipRepository = shipRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    public List<Ship> getAll() {
        return shipRepository.findAll();
    }

    public Ship addShip(ShipDTO dto) {
        Manufacturer manufacturer = manufacturerRepository.findByName(dto.getManufacturerName());
        Ship ship = new Ship(dto.getName(), manufacturer, dto.getType(), dto.getLength(), dto.getCost());

        return shipRepository.save(ship);
    }
}
