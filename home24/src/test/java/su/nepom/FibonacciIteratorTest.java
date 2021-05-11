package su.nepom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciIteratorTest {
    // https://ru.wikipedia.org/wiki/Числа_Фибоначчи
    static final int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711};

    @Test
    void test() {
        var it = new FibonacciIterator();

        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], it.next(), Integer.toString(i));
        }
    }

}
