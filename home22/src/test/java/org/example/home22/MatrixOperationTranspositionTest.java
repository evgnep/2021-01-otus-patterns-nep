package org.example.home22;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.testng.Assert.*;

public class MatrixOperationTranspositionTest {
    @Test
    void test() {
        var input = new ByteArrayInputStream("3 2\n1 2 3\n4 5 6".getBytes());
        var output = new ByteArrayOutputStream();
        new MatrixOperationTransposition().execute(input, output);

        assertEquals(output.toString(), "2 3\r\n" +
                "1 4 \r\n" +
                "2 5 \r\n" +
                "3 6 \r\n");
    }
}
