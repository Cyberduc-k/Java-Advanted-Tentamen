package nl.inholland.exam.ships.tymoooijevaar.controller;

import nl.inholland.exam.ships.tymoooijevaar.exception.ManufacturerExistsException;
import nl.inholland.exam.ships.tymoooijevaar.model.Manufacturer;
import nl.inholland.exam.ships.tymoooijevaar.model.dto.ManufacturerDTO;
import nl.inholland.exam.ships.tymoooijevaar.service.ManufacturerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/manufacturers")
public class ManufacturerController {
    private final ManufacturerService service;
    private final Logger logger = LoggerFactory.getLogger(ManufacturerController.class);

    private ManufacturerController(ManufacturerService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Manufacturer>> getAllManufacturers(
            @RequestParam(value = "affiliation", required = false)
            String affiliation
    ) {
        logger.info("getAllManufacturers: {}", affiliation);

        if (affiliation == null)
            return new ResponseEntity<>(service.getAllManufacturers(), HttpStatus.OK);
        else
            return new ResponseEntity<>(service.getAllManufacturersByAffiliation(affiliation), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Manufacturer> addManufacturer(@RequestBody ManufacturerDTO dto) {
        logger.info("addManufacturer: {}", dto);

        try {
            return new ResponseEntity<>(service.addManufacturer(dto), HttpStatus.OK);
        } catch (ManufacturerExistsException ex) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
