package su.nepom;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.function.Supplier;

public class Main {
    static void generate(OutputStream stream, int count, Iterator iterator) {
        try (var pw = new PrintWriter(stream)) {
            for (; count > 0 && iterator.hasNext(); --count)
                pw.println(iterator.next());
        }
    }

    static Supplier<Iterator> getIteratorFactory(boolean reverse, int count) {
        return () -> reverse ? new ReverseFibonacciIterator(count) : new FibonacciIterator();
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 3)
            throw new IllegalArgumentException("file count reverse[0|1]");

        var file = args[0];
        var count = Integer.parseInt(args[1]);
        var reverse = Integer.parseInt(args[2]) == 1;

        var factory = getIteratorFactory(reverse, count);

        try (var out = new FileOutputStream(file)) {
            generate(out, count, factory.get());
        }
    }
}
