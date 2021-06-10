package nl.inholland.exam.ships.tymoooijevaar.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer {
    @Id
    private long id;
    private String name;
    private String affiliation;
    private String ceo;

    @OneToMany(mappedBy = "manufacturer")
    @JsonManagedReference
    private List<Ship> ships;
}
