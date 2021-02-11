package su.nepom.patterns.home1.model.commands;

import org.junit.Test;
import su.nepom.patterns.home1.model.Rotatable;
import su.nepom.patterns.home1.model.UObject;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class RotateImplTest {

    @Test
    public void execute() {
        var obj = mock(UObject.class);
        var rotatable = mock(Rotatable.class);
        when(obj.queryInterface(eq(Rotatable.class))).thenReturn(rotatable);

        when(rotatable.getAngle()).thenReturn(42);
        when(rotatable.getAngleVelocity()).thenReturn(-1);

        new RotateImpl().execute(obj);

        verify(rotatable).setAngle(eq(41));
    }
}