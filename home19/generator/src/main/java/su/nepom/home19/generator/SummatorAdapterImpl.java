package su.nepom.home19.generator;

import java.io.IOException;

public class SummatorAdapterImpl implements SummatorAdapter {
    private final String summatorJar;

    public SummatorAdapterImpl(String summatorJar) {
        this.summatorJar = summatorJar;
    }

    @Override
    public void sum(String fileWithMatrix) {
        String err;
        try {
            String[] args = {"java", "-jar", summatorJar, fileWithMatrix, "res.txt"};
            var proc = Runtime.getRuntime().exec(args);
            err = new String(proc.getErrorStream().readAllBytes());
            var res = proc.waitFor();
            System.out.println("Result: " + res + "\n" + err);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!err.isBlank())
            throw new RuntimeException(err);
    }
}
