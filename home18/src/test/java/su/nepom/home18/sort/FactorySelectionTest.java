package su.nepom.home18.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactorySelectionTest {
    @Test
    void test() {
        var data = Utils.unsorted();
        new FactorySelection().createSorter().sort(data);

        assertThat(data).containsExactly(Utils.sorted());
    }
}
