package nl.inholland.exam.ships.tymoooijevaar.exception;

public class ManufacturerExistsException extends Exception {
    public ManufacturerExistsException() {
        super("A manufacturer with that name already exists");
    }
}
