package org.example.home22;

public class MatrixOperationTotal extends MatrixOperation {
    @Override
    protected int[][] doOperation(int[][] src) {
        var height = src.length / 2;
        var width = height == 0 ? 0 : src[0].length;

        var res = new int[height][];

        for (int y = 0; y < height; ++y) {
            res[y] = new int[width];
            for (int x = 0; x < width; ++x)
                res[y][x] = src[y][x] + src[y + height][x];
        }

        return res;
    }
}
