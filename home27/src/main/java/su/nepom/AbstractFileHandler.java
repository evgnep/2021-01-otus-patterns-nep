package su.nepom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractFileHandler implements FileHandler {
    private FileHandler next;

    @Override
    public void setNext(FileHandler handler) {
        next = handler;
    }

    @Override
    public void handle(String input, String output) throws IOException {
        if (check(input)) {
            process(input, output);
        }
        else if (next != null)
            next.handle(input, output);
        else
            throw new UnsupportedOperationException("Cant process " + input);
    }

    private void process(String input, String output) {
        System.out.println("Обработчик " + this + " получил файл " + input);
        try {
            if (new File(output).isFile())
                Files.delete(Path.of(output));
            Files.copy(Path.of(input), Path.of(output));
        } catch (IOException e) {
            throw new RuntimeException(e);
            //System.out.println(e.toString());
            //e.printStackTrace();
        }
    }

    protected abstract boolean check(String filename) throws FileNotFoundException, IOException;
}
