package primes;

import java.math.BigInteger;

public class PollardP_1 {
    BigInteger n;
    BigInteger upper;

    public PollardP_1(BigInteger n, BigInteger upper) {
        this.n = n;
        this.upper = upper;
    }

    private BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(a.gcd(b));
    }

    public BigInteger run() {
        BigInteger exponent = BigInteger.ONE;
        for (BigInteger i = BigInteger.TWO; i.compareTo(upper) < 1; i.add(BigInteger.ONE))
            exponent = lcm(exponent, i);
        BigInteger g = BigInteger.TWO.modPow(exponent, n).subtract(BigInteger.ONE).gcd(n);
        if (g.equals(BigInteger.ONE) || g.equals(n))
            return BigInteger.ZERO;
        return g;
    }
}
