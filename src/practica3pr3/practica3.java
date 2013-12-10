package practica3pr3;

import java.math.BigInteger;

public class practica3 {

    public static void main(String[] args) {
        System.out.println("Inicio de programa\n");

        BigInteger[][] pares = new BigInteger[][]{
            {new BigInteger("744212342130"), new BigInteger("9123")},
            {new BigInteger("83033441234"), new BigInteger("47854")},
            {new BigInteger("27745300467"), new BigInteger("773578")},
            {new BigInteger("45678787849"), new BigInteger("8036756756243262650")},
            {new BigInteger("99655345347"), new BigInteger("789069340254532684385676777705")},
            {new BigInteger("11131323455"), new BigInteger("34045234513513451489568954746728234340")}};

        long[] time = new long[3 * 6];
        long aux;
        BigInteger[] result = new BigInteger[3 * 6];
        Multiplicacion mul;
        long repeat = 10;

        for (int i = 0; i < pares.length; i++) {

            if (i < 3) { // Solo los 3 primeros pares
                mul = new SumasSucesivas();
                time[i * 3] = 0;

                for (int c = 0; c < repeat; c++) {
                    aux = System.nanoTime();
                    result[i * 3] = mul.multiplica(pares[i][0], pares[i][1]);
                    time[i * 3] += (System.nanoTime() - aux);
                }
                if (!CompruebaMultiplicacion.comprueba(pares[i][0], pares[i][1], result[i * 3]))
                    System.out.println("ERROR");

                time[i * 3] /= repeat;
            } else {
                result[i * 3] = BigInteger.ZERO;
                time[i * 3] = 0;
            }

            mul = new Rusa();
            time[1 + i * 3] = 0;

            for (int c = 0; c < repeat; c++) {
                aux = System.nanoTime();
                // Invertimos la llamada para que en todos la recursividad sea
                // controlada por la segunda instancia de cada par.
                result[1 + i * 3] = mul.multiplica(pares[i][1], pares[i][0]);
                time[1 + i * 3] += (System.nanoTime() - aux);
            }
            if (!CompruebaMultiplicacion.comprueba(pares[i][0], pares[i][1], result[1 + i * 3]))
                System.out.println("ERROR");

            time[1 + i * 3] /= repeat;

            mul = new Egipcia();
            time[2 + i * 3] = 0;

            for (int c = 0; c < repeat; c++) {
                aux = System.nanoTime();
                result[2 + i * 3] = mul.multiplica(pares[i][0], pares[i][1]);
                time[2 + i * 3] += (System.nanoTime() - aux);
            }
            if (!CompruebaMultiplicacion.comprueba(pares[i][0], pares[i][1], result[2 + i * 3]))
                System.out.println("ERROR");
            time[2 + i * 3] /= repeat;
        }

        imprimeBonito(pares, result, time);
        System.out.println("\nFin de programa");
    }

    private static void imprimeBonito(BigInteger[][] pares, BigInteger[] result, long[] time) {
        System.out.println("Tamaño de las ristras Tiempo Sumas Tiempo Rusa Tiempo Egipcia"
                + " Resultados Sumas Resultados Rusa Resultados Egipcia");

        for (int i = 0; i < pares.length; i++) {
            System.out.printf("%21d", pares[i][1].toString().length());
            System.out.printf("%13d", time[i * 3]);
            System.out.printf("%12d", time[1 + i * 3]);
            System.out.printf("%15d", time[2 + i * 3]);
            System.out.printf("%17.6g", result[i * 3].doubleValue());
            System.out.printf("%16.6g", result[1 + i * 3].doubleValue());
            System.out.printf("%19.6g", result[2 + i * 3].doubleValue());
            System.out.println("");
        }

    }
}

