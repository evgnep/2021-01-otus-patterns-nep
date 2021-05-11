package su.nepom;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonFileHandlerTest {
    @Test
    void test_ok() throws IOException {
        new JsonFileHandler().handle("test.json", "out1");
    }

    @Test
    void test_invalid() throws IOException {
        assertThrows(UnsupportedOperationException.class, () -> new JsonFileHandler().handle("test.csv", "out1"));
    }
}
