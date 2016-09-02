import java.util.*;
import java.io.*;
import java.math.*;

class Main {
        
    private static int SIZE = 1003;
    private static BigInteger[] bigs = new BigInteger[SIZE];

    public static void main(String[] args) throws IOException {
    
        for (int i = 0; i < SIZE; i++)
            bigs[i] = fib(new BigInteger(String.valueOf(i)));

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        BigInteger two = new BigInteger("2");
        while ((in = input.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(in);
            System.out.println(fib(two.add(new BigInteger(in))));
        }
        input.close();
    }

    private static BigInteger fib(BigInteger n) {
        BigInteger i = new BigInteger("1");   
        BigInteger h = new BigInteger("1");   
        BigInteger j = new BigInteger("0");   
        BigInteger k = new BigInteger("0");   
        BigInteger two = new BigInteger("2");
        BigInteger t;
        while (n.compareTo(BigInteger.ZERO) > 0) {
            if (n.mod(two).compareTo(BigInteger.ZERO) != 0) {
                t = j.multiply(h);
                j = i.multiply(h).add(j.multiply(k)).add(t);
                i = i.multiply(k).add(t);
            }
            t = h.multiply(h);
            h = two.multiply(k.multiply(h)).add(t);
            k = k.multiply(k).add(t);
            n = n.divide(two);
        }
        return j;
    }
}
