package su.nepom.home19.generator;

import org.junit.jupiter.api.Test;
import su.nepom.home19.summator.Reader;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
    @Test
    void readSize() {
        var s = new Scanner("2 3");
        var res = Reader.readSize(s);
        assertEquals(res.width, 2);
        assertEquals(res.height, 3);
    }

    @Test
    void readMatrix() {
        var scanner = new Scanner("1 2\n3 4\n5 -6");
        var size = new Reader.Size();
        size.width = 2;
        size.height = 3;
        var m = Reader.readMatrix(scanner, size);

        assertEquals(3, m.length);
        assertArrayEquals(new int[]{1, 2}, m[0]);
        assertArrayEquals(new int[]{5, -6}, m[2]);
    }
}
