package su.nepom;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileHandler extends AbstractFileHandler {
    @Override
    protected boolean check(String filename) {
        return true;
    }

    @Override
    public String toString() {
        return "TextFileHandler";
    }
}
