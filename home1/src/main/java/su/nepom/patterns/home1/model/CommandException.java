package su.nepom.patterns.home1.model;

public class CommandException extends Exception {
    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandException() {
    }

    public CommandException(String message) {
        super(message);
    }
}
