package primes;

import java.math.BigInteger;

public class PollardRho {
    BigInteger n;
    int offset;

    public PollardRho(BigInteger n, int offset) {
        this.n = n;
        this.offset = offset;
    }

    private BigInteger trans(BigInteger x) {
        return x.pow(2).add(BigInteger.valueOf(offset + 1));
    }

    public BigInteger run() {
        BigInteger x = BigInteger.TWO, y = x, d = BigInteger.ONE;
        while (d.equals(BigInteger.ONE)) {
            x = trans(x).mod(n);
            y = trans(trans(y)).mod(n);
            d = y.subtract(x).gcd(n);
        }
        if (d.equals(n))
            return BigInteger.ZERO;
        return d;
    }
}
