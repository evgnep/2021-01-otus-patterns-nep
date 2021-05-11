package su.nepom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseFibonacciIteratorTest {
    @Test
    void bine() {
        for (int i = 0; i < FibonacciIteratorTest.expected.length; ++i) {
            assertEquals(FibonacciIteratorTest.expected[i], ReverseFibonacciIterator.bine(i), Integer.toString(i));
        }
    }

    @Test
    void iterator() {
        var it = new ReverseFibonacciIterator(FibonacciIteratorTest.expected.length-1);
        for (int i = FibonacciIteratorTest.expected.length - 1; i >=0; --i) {
            assertEquals(FibonacciIteratorTest.expected[i], it.next(), Integer.toString(i));
        }
        assertFalse(it.hasNext());
    }
}
