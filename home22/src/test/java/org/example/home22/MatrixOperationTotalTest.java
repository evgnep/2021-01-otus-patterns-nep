package org.example.home22;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.testng.Assert.*;

public class MatrixOperationTotalTest {
    @Test
    void test() {
        var input = new ByteArrayInputStream("3 2\n1 2 3\n4 5 6".getBytes());
        var output = new ByteArrayOutputStream();
        new MatrixOperationTotal().execute(input, output);

        assertEquals(output.toString(), "3 1\r\n" +
                "5 7 9 \r\n");
    }

}
