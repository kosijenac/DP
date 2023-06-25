package primes;

import java.math.BigInteger;

public class TrialDiv {
    BigInteger n;
    int offset;
    int shift;

    public TrialDiv(BigInteger n, int offset, int numProc) {
        this.n = n;
        this.offset = offset;
        this.shift = numProc;
    }

    public BigInteger run() {
        BigInteger d = BigInteger.valueOf(offset + 2);
        for (; d.pow(2).compareTo(n) < 1; d = d.add(BigInteger.valueOf(shift)))
            if (n.mod(d).equals(BigInteger.ZERO))
                return d;
        return BigInteger.ZERO;
    }
}
