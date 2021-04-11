package su.nepom.home19.generator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {
    @Test
    void should_generateMatrix() {
        var out = new ByteArrayOutputStream();
        Generator.generate(out, 2, 3);

        var in = new ByteArrayInputStream(out.toByteArray());
        var scanner = new Scanner(in);

        assertEquals(scanner.nextInt(), 2);
        assertEquals(scanner.nextInt(), 3);

        int count = 0;
        while (scanner.hasNext()) {
            scanner.nextInt();
            count += 1;
        }

        assertEquals(count, 2*3 * 2);
    }

}
