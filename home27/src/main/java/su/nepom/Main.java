package su.nepom;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String... args) throws Exception {
        if (args.length < 1)
            throw new IllegalArgumentException("call with file with file list");

        var xml = new XmlFileHandler();
        var json = new JsonFileHandler();
        var csv = new CsvFileHandler();
        var text = new TextFileHandler();
        xml.setNext(json);
        json.setNext(csv);
        csv.setNext(text);

        FileHandler top = xml;

        try (var br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            int no = 0;
            while ((line = br.readLine()) != null) {
                top.handle(line, "out" + (++no));
            }
        }
    }
}
