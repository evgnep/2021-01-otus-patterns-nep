package su.nepom.home18;

import su.nepom.home18.sort.Factory;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ReadSortWrite {
    private final Factory sorterFactory;

    public ReadSortWrite(Factory sorterFactory) {
        this.sorterFactory = sorterFactory;
    }

    public void doJob(InputStream src, OutputStream dest) {
        var srcWrapped = new Scanner(src);
        srcWrapped.useLocale(Locale.US);
        var destWrapped = new PrintWriter(dest);

        doJob(srcWrapped, destWrapped);

        destWrapped.close();
    }

    private void doJob(Scanner src, PrintWriter trg) {
        var data = new ArrayList<Double>();
        while (src.hasNextDouble())
            data.add(src.nextDouble());

        var res = data.stream().mapToDouble(x -> x).toArray();
        var sorter = sorterFactory.createSorter();

        sorter.sort(res);

        trg.write(sorterFactory.toString() + "\n");
        for (var e : res) {
            trg.write(Double.toString(e));
            trg.write(' ');
        }
    }
}
