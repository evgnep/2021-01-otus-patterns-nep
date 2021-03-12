package su.nepom.patterns.home1.model.commands;

import org.junit.Test;
import su.nepom.patterns.home1.model.CommandException;
import su.nepom.patterns.home1.model.Rotatable;
import su.nepom.patterns.home1.model.UObject;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class RotateImplTest {

    @Test
    public void execute() throws CommandException {
        var obj = mock(UObject.class);
        var rotatable = mock(Rotatable.class);
        when(obj.queryInterface(eq(Rotatable.class))).thenReturn(Optional.of(rotatable));

        when(rotatable.getAngle()).thenReturn(42.);
        when(rotatable.getAngleVelocity()).thenReturn(-1.);

        new RotateImpl().execute(obj);

        verify(rotatable).setAngle(eq(41.));
    }

    @Test
    public void shouldThrowThenNotRotatable() {
        var obj = mock(UObject.class);

        assertThatThrownBy(()-> new RotateImpl().execute(obj)).isInstanceOf(CommandException.class);
    }

    @Test
    public void shouldThrowThenSetAngleError() {
        var obj = mock(UObject.class);
        var rotatable = mock(Rotatable.class);
        when(obj.queryInterface(eq(Rotatable.class))).thenReturn(Optional.of(rotatable));

        when(rotatable.getAngle()).thenReturn(42.);
        when(rotatable.getAngleVelocity()).thenReturn(-1.);
        doThrow(new RuntimeException("Some error")).when(rotatable).setAngle(anyDouble());

        assertThatThrownBy(()-> new RotateImpl().execute(obj)).isInstanceOf(CommandException.class).hasCauseInstanceOf(RuntimeException.class);
    }
}