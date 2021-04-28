package su.nepom;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Main {
    static void generate(OutputStream stream, int count, Iterator iterator) {
        try (var pw = new PrintWriter(stream)) {
            for (; count > 0 && iterator.hasNext(); --count)
                pw.println(iterator.next());
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 3)
            throw new IllegalArgumentException("file count reverse[0|1]");

        var file = args[0];
        var count = Integer.parseInt(args[1]);
        var reverse = Integer.parseInt(args[2]) == 1;

        try (var out = new FileOutputStream(file)) {
            generate(out, count, reverse ? new ReverseFibonacciIterator(count) : new FibonacciIterator());
        }
    }
}
