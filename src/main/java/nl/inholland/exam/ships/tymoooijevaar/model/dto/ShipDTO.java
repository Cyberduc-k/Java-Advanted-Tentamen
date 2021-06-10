package nl.inholland.exam.ships.tymoooijevaar.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ShipDTO {
    private String name;
    private String manufacturerName;
    private String type;
    private double length;
    private long cost;
}
