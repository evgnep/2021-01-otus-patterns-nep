package org.example.home22;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.testng.Assert.*;

public class MatrixOperationDeterminantTest {

    @Test
    public void testDoOperation() {
        var input = new ByteArrayInputStream("3 3\n1 -1 3\n4 5 6\n7 8 9".getBytes());
        var output = new ByteArrayOutputStream();
        new MatrixOperationDeterminant().execute(input, output);

        assertEquals(output.toString(), "1 1\r\n-18 \r\n");
    }

    @Test
    public void testCalc() {
        int[][] src1 = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        assertEquals(MatrixOperationDeterminant.calc(src1), 0);

        int[][] src2 = new int[][] {
                {1, -1, 3},
                {4, 5, 6},
                {7, 8, 9}};

        assertEquals(MatrixOperationDeterminant.calc(src2), -18);
    }

    @Test
    public void testMinor() {
        int[][] src = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        var m0 = MatrixOperationDeterminant.minor(src, 0);
        assertEquals(m0[0], new int[] {5, 6});
        assertEquals(m0[1], new int[] {8, 9});

        var m1 = MatrixOperationDeterminant.minor(src, 1);
        assertEquals(m1[0], new int[] {4, 6});
        assertEquals(m1[1], new int[] {7, 9});

        var m2 = MatrixOperationDeterminant.minor(src, 2);
        assertEquals(m2[0], new int[] {4, 5});
        assertEquals(m2[1], new int[] {7, 8});
    }
}
