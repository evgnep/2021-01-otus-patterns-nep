package su.nepom.patterns.home1.model;

/**
 * Команда. Можно выполнить над объектом
 */
public interface Command {
    void execute(UObject object) throws CommandException;
}
