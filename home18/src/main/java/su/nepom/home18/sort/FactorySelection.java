package su.nepom.home18.sort;

/// Реализация взята из https://www.examclouds.com/ru/java/java-core-russian/sortirovka-viborom
class SorterSelection implements Sorter {
    @Override
    public void sort(double[] data) {
        for (int i = 0; i < data.length; i++) {
            int pos = i;
            var min = data[i];
            // цикл выбора наименьшего элемента
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < min) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = data[j];
                }
            }
            data[pos] = data[i];
            data[i] = min;    // меняем местами наименьший с array[i]
        }
    }
}

public class FactorySelection implements Factory {
    @Override
    public Sorter createSorter() {
        return new SorterSelection();
    }

    @Override
    public String toString() {
        return "Сортировка выбором";
    }
}
