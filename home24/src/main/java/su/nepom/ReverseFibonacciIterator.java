package su.nepom;

public class ReverseFibonacciIterator implements Iterator {
    private int prev[] = {0, 0};

    // Формула Бине: http://mech.math.msu.su/~shvetz/54/inf/perl-problems/chFibonacci_sIdeas.xhtml
    private static final double
            R5 = Math.sqrt(5),
            FI = (1 + R5)/2;
    static int bine(int n) {
        double r = (Math.pow(FI, n) - Math.pow(-FI, -n)) / R5;
        return (int)Math.round(r);
    }

    public ReverseFibonacciIterator(int startNo) {
        if (startNo < 0)
            throw new IllegalArgumentException("startNo >= 0");

        prev[0] = bine(startNo+1);
        prev[1] = bine(startNo+2);
    }

    @Override
    public int next() {
        if (prev[0] == 0)
            throw new IllegalStateException("!hasNext");

        var res = prev[1] - prev[0];
        prev[1] = prev[0];
        prev[0] = res;
        return res;
    }

    @Override
    public boolean hasNext() {
        return prev[0] != 0;
    }
}
