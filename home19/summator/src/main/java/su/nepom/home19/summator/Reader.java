package su.nepom.home19.summator;

import java.io.InputStream;
import java.util.Scanner;

public class Reader {
    public static class Size {
        int width, height;
    }

    public static Size readSize(Scanner scanner) {
        var res = new Size();
        res.width = scanner.nextInt();
        res.height = scanner.nextInt();
        return res;
    }

    public static int[][] readMatrix(Scanner scanner, Size size) {
        int[][] res = new int[size.height][];
        for (int i = 0; i < size.height; ++i) {
            res[i] = new int[size.width];
            for (int j = 0; j < size.width; ++j)
                res[i][j] = scanner.nextInt();
        }

        return res;
    }
}
