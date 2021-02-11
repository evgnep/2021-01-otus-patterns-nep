package su.nepom.patterns.home1.model.object;

import su.nepom.patterns.home1.model.Rotatable;
import su.nepom.patterns.home1.model.RotatableManage;
import su.nepom.patterns.home1.model.UObject;

import java.util.List;

public class RotatableImpl implements RotatableManage, UObject.Part {
    private int angle, angleVelocity;

    public RotatableImpl(int angle, int angleVelocity) {
        this.angle = angle;
        this.angleVelocity = angleVelocity;
    }

    @Override
    public List<Class<?>> canQueryAs() {
        return List.of(Rotatable.class, RotatableManage.class);
    }

    @Override
    public int getAngle() {
        return angle;
    }

    @Override
    public void setAngle(int angle) {
        this.angle = angle;
    }

    @Override
    public int getAngleVelocity() {
        return angleVelocity;
    }

    @Override
    public void setAngleVelocity(int angleVelocity) {
        this.angleVelocity = angleVelocity;
    }
}
