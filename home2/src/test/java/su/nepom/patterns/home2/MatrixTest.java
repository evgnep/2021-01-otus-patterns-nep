package su.nepom.patterns.home2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class MatrixTest {
    @Test
    public void matrix1x1() {
        var m = new Matrix(1, 1);
        assertThat(m.getRows()).isEqualTo(1);
        assertThat(m.getColumns()).isEqualTo(1);
        assertThat(m.get(0, 0)).isNull();
        m.set(0, 0, 42f);
        assertThat(m.get(0, 0)).isEqualTo(42f);

        assertThatThrownBy(() -> m.get(1, 0));

        assertThat(m.toString()).isEqualTo("[42.0]\n");
    }

    @Test
    public void matrix2x3() {
        var m = new Matrix(2, 3);
        assertThat(m.get(1, 2)).isNull();
        m.set(0, 2, 42f);
        assertThat(m.get(0, 2)).isEqualTo(42f);
        assertThat(m.get(1, 2)).isNull();
    }
}