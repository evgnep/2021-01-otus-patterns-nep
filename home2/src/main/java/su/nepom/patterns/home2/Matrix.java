package su.nepom.patterns.home2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Двумерная матрица float, фиксированного размера
 */
public class Matrix {
    private final List<List<Float>> data;
    private final int columns;

    public Matrix(int rows, int columns) {
        this.columns = columns;
        data = new ArrayList<>(rows);
        for (int row = 0; row < rows; ++row) {
            var rowData = new ArrayList<Float>(columns);
            data.add(rowData);
            for (int column = 0; column < columns; ++column)
                rowData.add(null);
        }
    }

    public Float get(int row, int column) {
        return data.get(row).get(column);
    }

    public void set(int row, int column, Float value) {
        data.get(row).set(column, value);
    }

    public int getRows() {
        return data.size();
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (var row : data)
            res.append(row).append("\n");
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return columns == matrix.columns &&
                data.equals(matrix.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
