package su.nepom.home18.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryMergeTest {
    @Test
    void test() {
        var data = Utils.unsorted();
        new FactoryMerge().createSorter().sort(data);

        assertThat(data).containsExactly(Utils.sorted());
    }

}
