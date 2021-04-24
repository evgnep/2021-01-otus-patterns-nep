package su.nepom.home19.summator;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Writer {
    public static void write(int[][] m, OutputStream out) {
        try (var pw = new PrintWriter(out)) {
            for (int[] row : m) {
                for (int e : row) {
                    pw.print(e);
                    pw.print(' ');
                }
                pw.println();
            }
        }
    }
}
