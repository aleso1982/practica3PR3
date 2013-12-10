package practica3pr3;

import java.math.BigInteger;

public class Rusa implements Multiplicacion {
    
     public BigInteger multiplica(BigInteger n, BigInteger m) {
         final BigInteger dos = new BigInteger("2");
         
         if (n.compareTo(new BigInteger("1")) >= 0) {
             if (n.mod(dos).compareTo(new BigInteger("0")) == 0){
                 return multiplica(n.divide(dos), m.multiply(dos));
             } else {
                 return m.add(multiplica(n.divide(dos), m.multiply(dos)));
             }
         }
         
         return new BigInteger("0");
     }
    
}

