package org.example.home22;

public class MatrixOperationTransposition extends MatrixOperation {
    @Override
    protected int[][] doOperation(int[][] src) {
        var height = src.length;
        var width = height == 0 ? 0 : src[0].length;
        var res = new int[width][];

        for (int x = 0; x < width; ++x) {
            res[x] = new int[height];
            for (int y = 0; y < height; ++y)
                res[x][y] = src[y][x];
        }

        return res;
    }
}
