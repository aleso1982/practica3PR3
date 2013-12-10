package practica3pr3;

import java.math.BigInteger;

public class SumasSucesivas implements Multiplicacion {
    
     public BigInteger multiplica(BigInteger x, BigInteger y) {
         BigInteger aux = new BigInteger("0");
         
         if (y.compareTo(aux) == 0) return y;
         return x.add(multiplica(x, y.add(new BigInteger("-1"))));
     }
    
}
