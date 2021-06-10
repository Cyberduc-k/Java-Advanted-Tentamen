package nl.inholland.exam.ships.tymoooijevaar.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ship {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToOne
    @JsonBackReference
    private Manufacturer manufacturer;
    private String type;
    private double length;
    private long cost;

    public Ship(String name, Manufacturer manufacturer, String type, double length, long cost) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.type = type;
        this.length = length;
        this.cost = cost;
    }
}
