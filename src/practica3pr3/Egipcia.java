package practica3pr3;

import java.math.BigInteger;

public class Egipcia implements Multiplicacion {

    public BigInteger multiplica(BigInteger x, BigInteger y) {
        return multiplicaEgipcia(x, y, new BigInteger("1"))[0];
    }

    private BigInteger[] multiplicaEgipcia(BigInteger n, BigInteger m, BigInteger doble1) {
        BigInteger[] aux = new BigInteger[2];

        if (doble1.compareTo(m) == 1) {
            aux[0] = new BigInteger("0");
            aux[1] = new BigInteger("0");
            return aux;
        } else {
            BigInteger[] ps = multiplicaEgipcia(n, m, doble1.multiply(new BigInteger("2")));
            if (ps[1].add(doble1).compareTo(m) <= 0) {
                aux[0] = ps[0].add(n.multiply(doble1));
                aux[1] = ps[1].add(doble1);
                return aux;
            } else
                return ps;
        }
    }
}