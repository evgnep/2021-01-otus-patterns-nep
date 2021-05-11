package su.nepom;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XmlFileHandlerTest {
    @Test
    void test_ok() throws IOException {
        new XmlFileHandler().handle("test.xml", "out1");
    }

    @Test
    void test_invalid() throws IOException {
        assertThrows(UnsupportedOperationException.class, () -> new XmlFileHandler().handle("test.csv", "out1"));
    }
}
