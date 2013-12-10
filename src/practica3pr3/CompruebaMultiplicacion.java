package practica3pr3;

import java.math.BigInteger;

public class CompruebaMultiplicacion {
    
    public static boolean comprueba(BigInteger x, BigInteger y, BigInteger result) {
        return x.multiply(y).compareTo(result)==0?true:false;
    }
}