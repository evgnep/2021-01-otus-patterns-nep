package su.nepom.home19.summator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Summator {
    public static void main(String... args) throws IOException {
        if (args.length < 2)
            throw new IllegalArgumentException("input_file output_file");

        try (var input = new FileInputStream(args[0]);
             var output = new FileOutputStream(args[1])) {

            var scanner = new Scanner(input);

            System.out.println("reading...");
            var size = Reader.readSize(scanner);
            var m1 = Reader.readMatrix(scanner, size);
            var m2 = Reader.readMatrix(scanner, size);

            System.out.println("calc...");

            var sum = MatrixOps.sum(m1, m2);

            Writer.write(sum, output);

            System.out.println("complete");
        }
    }
}
