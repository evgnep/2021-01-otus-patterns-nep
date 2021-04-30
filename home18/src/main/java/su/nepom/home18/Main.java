package su.nepom.home18;

import su.nepom.home18.sort.Factory;
import su.nepom.home18.sort.FactoryInsertion;
import su.nepom.home18.sort.FactoryMerge;
import su.nepom.home18.sort.FactorySelection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 3)
            throw new IllegalArgumentException("src_file dest_file method");

        try (var src = new FileInputStream(args[0]);
             var trg = new FileOutputStream(args[1])) {

            Factory factory;
            switch (args[2]) {
                case "merge":
                    factory = new FactoryMerge();
                    break;
                case "selection":
                    factory = new FactorySelection();
                    break;
                case "insertion":
                    factory = new FactoryInsertion();
                    break;
                default:
                    throw new IllegalArgumentException("unknown algo: " + args[2]);
            }

            new ReadSortWrite(factory).doJob(src, trg);
        }
    }
}
