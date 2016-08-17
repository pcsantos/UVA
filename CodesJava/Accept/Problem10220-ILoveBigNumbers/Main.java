import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    private static final int SIZE = 1001;
    private static BigInteger[] fact = new BigInteger[SIZE];

    public static void main(String[] args) throws IOException {
    
        factorial();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            System.out.println(sumDigits(in));
        }
        input.close();
    }

    private static long sumDigits(String in) {
        char[] number = String.valueOf(fact[Integer.parseInt(in)]).toCharArray();
        long sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum += Integer.parseInt(String.valueOf(number[i]));
        }
        return sum;
    }

    private static void factorial() {
        fact[0] = new BigInteger("1");
        BigInteger aux = fact[0];
        for (int i = 1; i < SIZE; i++) {
            BigInteger bi = new BigInteger(String.valueOf(i));
            fact[i] = aux.multiply(bi);
            aux = fact[i];
        }
    }
}
