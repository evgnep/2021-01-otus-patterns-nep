package su.nepom.patterns.home2;

public class Main {

    public static void main(String... args) throws Exception {
        var m1 = new Matrix(5, 5);
        var m2 = new Matrix(5, 5);

        for (int row = 0; row < m1.getRows(); ++row)
            for (int col = 0; col < m1.getColumns(); ++col)
                m1.set(row, col, 1f);

        for (int row = 0; row < m2.getRows(); ++row)
            for (int col = 0; col < m2.getColumns(); ++col)
                m2.set(row, col, 2f);

        System.out.print(Multiplier.multiply(m1, m2, 5));
    }
}
