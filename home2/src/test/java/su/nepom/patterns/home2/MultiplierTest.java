package su.nepom.patterns.home2;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiplierTest {

    private Matrix a, b, res;

    @Before
    public void before() {
        a = new Matrix(3, 2);
        a.set(0, 0, 1f);
        a.set(0, 1, 2f);
        a.set(1, 0, 3f);
        a.set(1, 1, 4f);
        a.set(2, 0, 5f);
        a.set(2, 1, 6f);

        b = new Matrix(2, 3);
        b.set(0, 0, 11f);
        b.set(0, 1, 12f);
        b.set(0, 2, 13f);
        b.set(1, 0, 14f);
        b.set(1, 1, 15f);
        b.set(1, 2, 16f);

        res = new Matrix(3, 3);
        res.set(0, 0, 39f);
        res.set(0, 1, 42f);
        res.set(0, 2, 45f);
        res.set(1, 0, 89f);
        res.set(1, 1, 96f);
        res.set(1, 2, 103f);
        res.set(2, 0, 139f);
        res.set(2, 1, 150f);
        res.set(2, 2, 161f);
    }

    @Test
    public void oneThread() throws Exception {
        assertThat(Multiplier.multiply(a, b, 1, true)).isEqualTo(res);
    }

    @Test
    public void twoThreads() throws Exception {
        assertThat(Multiplier.multiply(a, b, 2, true)).isEqualTo(res);
    }

    @Test
    public void fiveThreads() throws Exception {
        assertThat(Multiplier.multiply(a, b, 5, true)).isEqualTo(res);
    }

    @Test
    public void manyThreads() throws Exception {
        assertThat(Multiplier.multiply(a, b, 42, true)).isEqualTo(res);
    }
}