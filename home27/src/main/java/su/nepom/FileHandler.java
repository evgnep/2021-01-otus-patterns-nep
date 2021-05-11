package su.nepom;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileHandler {
    void setNext(FileHandler handler);
    void handle(String input, String output) throws FileNotFoundException, IOException;
}
