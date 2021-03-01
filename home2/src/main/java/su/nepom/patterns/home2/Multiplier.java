package su.nepom.patterns.home2;

import java.util.ArrayList;
import java.util.List;

/**
 * Вычислитель произведения матриц на основе самодельного пула потоков
 */
public class Multiplier {
    private final Matrix a, b, result; // result = a * b
    private final List<Thread> threads = new ArrayList<>(); // созданные потоки
    private int nextRow = 0, nextColumn = 0; // очередной элемент для вычисления
    private final boolean log;

    private Multiplier(Matrix a, Matrix b, int threadsCount, boolean log) {
        this.a = a;
        this.b = b;
        this.result = new Matrix(a.getRows(), b.getColumns());
        this.log = log;

        for (int i = 0; i < threadsCount; ++i) { // создаем и запускаем потоки пула
            var thread = new Thread(this::task);
            thread.start();
            threads.add(thread);
        }
    }

    public static Matrix multiply(Matrix a, Matrix b, int threadsCount) throws Exception {
        return multiply(a, b, threadsCount, false);
    }

    public static Matrix multiply(Matrix a, Matrix b, int threadsCount, boolean log) throws Exception {
        return new Multiplier(a, b, threadsCount, log).getResult();
    }

    private void task() {
        if (log)
            System.out.println(Thread.currentThread().getName() + " start");

        int elemCount = 0;
        while (true) {
            int trgRow, trgColumn;
            synchronized (this) { // берет очередной элемент для вычисления и инкрементит его
                if (nextRow == result.getRows()) { // если элементов больше нет - поток останавливается
                    if (log)
                        System.out.println(Thread.currentThread().getName() + " stop, elemCount=" + elemCount);
                    return;
                }

                trgRow = nextRow;
                trgColumn = nextColumn;

                nextColumn += 1;
                if (nextColumn == result.getColumns()) {
                    nextRow += 1;
                    nextColumn = 0;
                }
            }

            /*
            Тут нет синхронизации - все потоки читают матрицы a и b (которые не модифицируются, пока идет вычисление)
            Каждый поток пишет в свой элемент матрицы результата (все ее элементы созданы заранее)
             */

            if (log)
                System.out.println(Thread.currentThread().getName() + ": " + trgRow + ", " + trgColumn);

            float res = 0;
            for (int i = 0; i < a.getColumns(); ++i) {
                res += a.get(trgRow, i) * b.get(i, trgColumn);
            }
            result.set(trgRow, trgColumn, res);

            elemCount += 1;

            if (log)
                System.out.println(Thread.currentThread().getName() + ": " + trgRow + ", " + trgColumn + " complete");
        }
    }

    private Matrix getResult() throws InterruptedException {
        for (var thread : threads) // дождемся конца вычисления
            thread.join();
        return result;
    }
}
