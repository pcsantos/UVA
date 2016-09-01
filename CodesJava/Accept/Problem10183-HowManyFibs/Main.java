import java.util.*;
import java.io.*;
import java.math.*;
class Main {
        
    private static int SIZE = 501;
    private static BigInteger[] bigs = new BigInteger[SIZE];

    public static void main(String[] args) throws IOException {
    
        for (int i = 0; i < SIZE; i++)
            bigs[i] = fib(new BigInteger(String.valueOf(i)));

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int qtdNumbers;
        while (!(in = input.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(in);
            BigInteger lower = new BigInteger(st.nextToken());
            BigInteger upper = new BigInteger(st.nextToken());
            qtdNumbers = getRangeNumbers(lower, upper);
            System.out.println(qtdNumbers);
        }
        input.close();
    }
    
    private static int getRangeNumbers(BigInteger lower, BigInteger upper) {
        int count = 0;
        for (int i = 2; i < SIZE; i++) {
            if (bigs[i].compareTo(lower) >= 0) {
                if (bigs[i].compareTo(upper) <= 0)
                    count++;
                else
                    break;
            }
        }
        return count;
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
