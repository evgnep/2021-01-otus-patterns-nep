package org.example.home22;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String... args) throws Exception {
        if (args.length != 3)
            throw new IllegalArgumentException("input output operation");

        MatrixOperation matrixOperation;
        switch (args[2]) {
            case "determinant":
                matrixOperation = new MatrixOperationDeterminant();
                break;
            case "total":
                matrixOperation = new MatrixOperationTotal();
                break;
            case "transposition":
                matrixOperation = new MatrixOperationTransposition();
                break;
            default:
                throw new IllegalArgumentException("unsupported operation");
        }

        try (var input = new FileInputStream(args[0]);
             var output = new FileOutputStream(args[1])) {

            matrixOperation.execute(input, output);
        }
    }
}
