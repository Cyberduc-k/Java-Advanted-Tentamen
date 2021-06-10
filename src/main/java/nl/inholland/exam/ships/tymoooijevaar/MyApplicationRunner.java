package nl.inholland.exam.ships.tymoooijevaar;

import nl.inholland.exam.ships.tymoooijevaar.exception.ManufacturerExistsException;
import nl.inholland.exam.ships.tymoooijevaar.model.Manufacturer;
import nl.inholland.exam.ships.tymoooijevaar.model.Ship;
import nl.inholland.exam.ships.tymoooijevaar.model.dto.ManufacturerDTO;
import nl.inholland.exam.ships.tymoooijevaar.model.dto.ShipDTO;
import nl.inholland.exam.ships.tymoooijevaar.service.ManufacturerService;
import nl.inholland.exam.ships.tymoooijevaar.service.ShipService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {
    private final ManufacturerService manufacturerService;
    private final ShipService shipService;

    private MyApplicationRunner(ManufacturerService manufacturerService, ShipService shipService) {
        this.manufacturerService = manufacturerService;
        this.shipService = shipService;
    }

    @Override
    public void run(ApplicationArguments args) throws ManufacturerExistsException {
        Manufacturer cec = manufacturerService.addManufacturer(new ManufacturerDTO(1000001L, "Corellian Engineering Corporation", "Rebel Alliance", "Corran Destt"));
        Manufacturer kdy = manufacturerService.addManufacturer(new ManufacturerDTO(1000002L, "Kuat Drive Yards", "Galactic Republic", "Kuat of Kuat"));
        Manufacturer sfs = manufacturerService.addManufacturer(new ManufacturerDTO(1000003L, "Sienar Fleet Systems", "Galactic Republic", "Raith Sienar"));

        Ship cr90 = shipService.addShip(new ShipDTO("CR90", cec.getName(), "Corvette", 150, 2700000));
        Ship executor = shipService.addShip(new ShipDTO("Executor", kdy.getName(), "Dreadnought", 19000, 325000000));
        Ship tie = shipService.addShip(new ShipDTO("TIE", sfs.getName(), "Fighter", 6.3, 60000));
        Ship lambda = shipService.addShip(new ShipDTO("Lambda", sfs.getName(), "Shuttle", 20, 140000));
    }
}
