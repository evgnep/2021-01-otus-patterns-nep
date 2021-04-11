package su.nepom.home19.summator;

public class MatrixOps {
    public static int[][] sum(int[][] a, int[][] b) {
        int[][] res = new int[a.length][];
        for (int i = 0; i < a.length; ++i) {
            var width = a[i].length;
            res[i] = new int[width];
            for (int j = 0; j < width; ++j)
                res[i][j] = a[i][j] + b[i][j];
        }
        return res;
    }
}
