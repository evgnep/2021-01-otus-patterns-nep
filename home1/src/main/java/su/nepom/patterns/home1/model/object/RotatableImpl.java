package su.nepom.patterns.home1.model.object;

import su.nepom.patterns.home1.model.Rotatable;
import su.nepom.patterns.home1.model.RotatableManage;
import su.nepom.patterns.home1.model.UObject;

import java.util.List;

public class RotatableImpl implements RotatableManage, UObject.Part {
    private double angle, angleVelocity;

    public RotatableImpl(double angle, double angleVelocity) {
        this.angle = angle;
        this.angleVelocity = angleVelocity;
    }

    @Override
    public List<Class<?>> canQueryAs() {
        return List.of(Rotatable.class, RotatableManage.class);
    }

    @Override
    public double getAngle() {
        return angle;
    }

    @Override
    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public double getAngleVelocity() {
        return angleVelocity;
    }

    @Override
    public void setAngleVelocity(double angleVelocity) {
        this.angleVelocity = angleVelocity;
    }
}
