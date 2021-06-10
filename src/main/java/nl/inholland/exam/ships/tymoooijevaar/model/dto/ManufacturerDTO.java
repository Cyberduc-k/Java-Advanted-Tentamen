package nl.inholland.exam.ships.tymoooijevaar.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ManufacturerDTO {
    private Long id;
    private String name;
    private String affiliation;
    private String ceo;
}
