package nl.inholland.exam.ships.tymoooijevaar.repository;

import nl.inholland.exam.ships.tymoooijevaar.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
}
