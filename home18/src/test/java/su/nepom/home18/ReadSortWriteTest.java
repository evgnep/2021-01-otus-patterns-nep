package su.nepom.home18;

import org.junit.jupiter.api.Test;
import su.nepom.home18.ReadSortWrite;
import su.nepom.home18.sort.Factory;
import su.nepom.home18.sort.Sorter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ReadSortWriteTest {
    @Test
    void doJob() throws IOException {
        var factory = mock(Factory.class);
        var sorter = mock(Sorter.class);

        when(factory.toString()).thenReturn("xyz");
        when(factory.createSorter()).thenReturn(sorter);
        doAnswer(invocation -> {
            double[] data = invocation.getArgument(0);
            for (int i = 0; i < data.length; ++i)
                data[i] += 1;
            return null;
        }).when(sorter).sort(any());


        var res = new ByteArrayOutputStream();
        new ReadSortWrite(factory).doJob(new ByteArrayInputStream("10 20 30 3.14".getBytes()), res);

        assertThat(res.toString()).isEqualTo("xyz\n" +
                "11.0 21.0 31.0 4.140000000000001 ");

    }
}
