package nl.inholland.exam.ships.tymoooijevaar.repository;

import nl.inholland.exam.ships.tymoooijevaar.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
    Manufacturer findByName(String name);
    List<Manufacturer> findAllByAffiliation(String affiliation);
}
