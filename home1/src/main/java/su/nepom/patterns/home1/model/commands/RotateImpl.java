package su.nepom.patterns.home1.model.commands;

import su.nepom.patterns.home1.model.Rotatable;
import su.nepom.patterns.home1.model.Rotate;
import su.nepom.patterns.home1.model.UObject;

public class RotateImpl implements Rotate {
    @Override
    public void execute(UObject object) {
        var rotatable = object.queryInterface(Rotatable.class);
        rotatable.setAngle(rotatable.getAngle() + rotatable.getAngleVelocity());
    }
}
