package su.nepom.home19.generator;

import java.io.*;
import java.util.Random;

public class Generator {
    private static void generateMatrix(PrintWriter out, int width, int height) {
        var r = new Random();
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                out.print(r.nextInt(20));
                out.print(' ');
            }
            out.println();
        }
        out.println();
    }

    public static void generate(OutputStream out, int width, int height) {
        try (var pw = new PrintWriter(out)) {
            pw.print(width);
            pw.print(' ');
            pw.print(height);
            pw.println();
            pw.println();

            for (int i = 0; i < 2; ++i)
                generateMatrix(pw, width, height);
        }
    }

    public static void main(String... args) throws IOException {
        if (args.length < 1)
            throw new IllegalArgumentException("summator_jar");

        SummatorAdapter summator = new SummatorAdapterImpl(args[0]);

        System.out.println("generating...");

        try(var out = new FileOutputStream("f2.txt")) {
            generate(out, 10, 10);
        }

        System.out.println("calculate...");

        summator.sum("f2.txt");

        System.out.println("complete");
    }
}
