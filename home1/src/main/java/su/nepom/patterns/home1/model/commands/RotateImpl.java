package su.nepom.patterns.home1.model.commands;

import su.nepom.patterns.home1.model.Command;
import su.nepom.patterns.home1.model.CommandException;
import su.nepom.patterns.home1.model.Rotatable;
import su.nepom.patterns.home1.model.UObject;

public class RotateImpl implements Command {
    @Override
    public void execute(UObject object) throws CommandException {
        var rotatable = object.queryInterface(Rotatable.class).orElseThrow(() -> new CommandException("Rotatable не поддерживается"));
        try {
            rotatable.setAngle(rotatable.getAngle() + rotatable.getAngleVelocity());
        }
        catch (Exception e) {
            throw new CommandException("Проблемы при выполнении команды Rotate", e);
        }
    }
}
