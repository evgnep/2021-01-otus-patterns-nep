package su.nepom;

public class FibonacciIterator implements Iterator {
    private int step = 0;
    private int prev[] = {0, 1};

    @Override
    public int next() {
        if (step < 2)
            return prev[step++];

        var res = prev[0] + prev[1];
        prev[0] = prev[1];
        prev[1] = res;
        return res;
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
