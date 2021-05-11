package su.nepom;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileHandler extends AbstractFileHandler {
    @Override
    protected boolean check(String filename) throws IOException {
        try (var br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line == null)
                return false;
            return line.indexOf(',') >= 0;
        }
    }

    @Override
    public String toString() {
        return "CsvFileHandler";
    }
}
