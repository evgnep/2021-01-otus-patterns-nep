package su.nepom.patterns.home1;

import su.nepom.patterns.home1.model.Rotatable;
import su.nepom.patterns.home1.model.RotatableManage;
import su.nepom.patterns.home1.model.commands.RotateImpl;
import su.nepom.patterns.home1.model.object.RotatableImpl;
import su.nepom.patterns.home1.model.object.UObjectImpl;

public class Main {
    public static void main(String ... args) {
        var tank1 = new UObjectImpl(new RotatableImpl(0, 11));

        var command1 = new RotateImpl();

        command1.execute(tank1);
        System.out.println(tank1.queryInterface(Rotatable.class).getAngle());

        tank1.queryInterface(RotatableManage.class).setAngleVelocity(42);
        command1.execute(tank1);
        System.out.println(tank1.queryInterface(Rotatable.class).getAngle());
    }
}
