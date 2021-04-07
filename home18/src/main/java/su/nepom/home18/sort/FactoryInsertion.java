package su.nepom.home18.sort;

// Взято из https://proglib.io/p/java-sorting-algorithms
class SorterInsertion implements Sorter {
    @Override
    public void sort(double[] data) {
        for (int i = 1; i < data.length; i++) {
            var current = data[i];
            int j = i - 1;
            while(j >= 0 && current < data[j]) {
                data[j+1] = data[j];
                j--;
            }
            // в этой точке мы вышли, так что j так же -1
            // или в первом элементе, где текущий >= a[j]
            data[j+1] = current;
        }
    }
}

public class FactoryInsertion implements Factory {
    @Override
    public Sorter createSorter() {
        return new SorterInsertion();
    }

    @Override
    public String toString() {
        return "Сортировка вставками";
    }
}
