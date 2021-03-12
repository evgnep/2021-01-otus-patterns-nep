package su.nepom.patterns.home1.model.object;

import static org.assertj.core.api.Assertions.assertThat;  // main one
import org.junit.Test;
import su.nepom.patterns.home1.model.Rotatable;
import su.nepom.patterns.home1.model.RotatableManage;

import java.util.List;

public class RotatableImplTest {
    private final RotatableImpl obj = new RotatableImpl(42, 4);

    @Test
    public void canQueryAs() {
        assertThat(obj.canQueryAs()).containsAll(List.of(Rotatable.class, RotatableManage.class));
    }

    @Test
    public void getAngle() {
        assertThat(obj.getAngle()).isEqualTo(42);

        obj.setAngle(4);
        assertThat(obj.getAngle()).isEqualTo(4);
    }

    @Test
    public void getAngleVelocity() {
        assertThat(obj.getAngleVelocity()).isEqualTo(4);

        obj.setAngleVelocity(-2);
        assertThat(obj.getAngleVelocity()).isEqualTo(-2);
    }
}