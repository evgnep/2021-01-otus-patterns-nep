package org.example.home22;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class MatrixOperation {
    private static int[][] readMatrix(InputStream input) {
        var scanner = new Scanner(input);
        int width = scanner.nextInt(), height = scanner.nextInt();
        int[][] res = new int[height][];
        for (int i = 0; i < height; ++i) {
            res[i] = new int[width];
            for (int j = 0; j < width; ++j)
                res[i][j] = scanner.nextInt();
        }

        return res;
    }

    private static void writeMatrix(OutputStream output, int[][] src) {
        try (var printWriter = new PrintWriter(output)) {
            printWriter.print(src.length > 0 ? src[0].length : 0);
            printWriter.print(' ');
            printWriter.print(src.length);
            printWriter.println();

            for (var row : src) {
                for (var elem : row) {
                    printWriter.print(elem);
                    printWriter.print(' ');
                }
                printWriter.println();
            }
        }
    }

    public void execute(InputStream input, OutputStream output) {
        var src = readMatrix(input);
        var trg = doOperation(src);
        writeMatrix(output, trg);
    }

    protected abstract int[][] doOperation(int[][] src);
}
