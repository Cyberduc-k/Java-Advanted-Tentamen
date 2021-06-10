package nl.inholland.exam.ships.tymoooijevaar.controller;

import nl.inholland.exam.ships.tymoooijevaar.model.Ship;
import nl.inholland.exam.ships.tymoooijevaar.model.dto.ShipDTO;
import nl.inholland.exam.ships.tymoooijevaar.service.ShipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ships")
public class ShipController {
    private final ShipService service;
    private final Logger logger = LoggerFactory.getLogger(ShipController.class);

    private ShipController(ShipService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ship> addShip(@RequestBody ShipDTO dto) {
        logger.info("addShip: {}", dto);

        return new ResponseEntity<>(service.addShip(dto), HttpStatus.OK);
    }
}
