package org.example.home22;

public class MatrixOperationDeterminant extends MatrixOperation {
    @Override
    protected int[][] doOperation(int[][] src) {
        var height = src.length;
        var width = height == 0 ? 0 : src[0].length;

        if (height != width)
            throw new IllegalArgumentException("Matrix should be square");

        if (height == 0)
            throw new IllegalArgumentException("Invalid size");

        return new int[][]{{calc(src)}};
    }

    static int calc(int[][] src) {
        if (src.length == 1)
            return 1;
        else if (src.length == 2)
            return src[0][0] * src[1][1] - src[0][1] * src[1][0];

        int det = 0;
        for (int x = 0, sign = 1; x < src.length; ++x, sign *= -1)
            det += sign * src[0][x] * calc(minor(src, x));

        return det;
    }

    static int[][] minor(int[][] src, int exceptCol) {
        var width = src.length - 1;
        var res = new int[width][];

        for (int srcY = 1; srcY <= width; ++srcY) {
            int y = srcY - 1;
            res[y] = new int[width];
            for (int srcX = 0, x = 0; srcX <= width; ++srcX) {
                if (srcX == exceptCol)
                    continue;

                res[y][x++] = src[srcY][srcX];
            }
        }

        return res;
    }
}
