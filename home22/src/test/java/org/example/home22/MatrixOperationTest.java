package org.example.home22;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import static org.testng.Assert.*;

public class MatrixOperationTest {
    private static class MatrixOperationStub extends MatrixOperation {
        @Override
        protected int[][] doOperation(int[][] src) {
            for (var row : src)
                for (int i = 0; i < row.length; ++i)
                    row[i] += 1;

            return src;
        }
    }

    @Test
    void test() {
        var input = new ByteArrayInputStream("3 2\n1 2 3\n4 5 6".getBytes());
        var output = new ByteArrayOutputStream();
        new MatrixOperationStub().execute(input, output);

        assertEquals(output.toString(), "3 2\r\n" +
                "2 3 4 \r\n" +
                "5 6 7 \r\n");
    }
}
