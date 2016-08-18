import java.util.*;
import java.io.*;

class Main {

    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    private static final int SIZE = 1050;
    private static boolean[] primes = new boolean[SIZE + 1];

    public static void main(String[] args) throws IOException {
        fillMap();
        sieve();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            int sum = 0;
            char[] array = in.toCharArray();
            for (int i = 0; i < array.length; i++) {
                sum += map.get(array[i]);
            }
            if (primes[sum])
                System.out.println("It is a prime word.");
            else
                System.out.println("It is not a prime word.");

        }
        input.close();
    }

    private static void fillMap() {
        char[] array = ALPHA.toCharArray();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i+1);
        }
    }

    private static void sieve() {
        for (int i = 1; i < SIZE; i++)
            primes[i] = true;
        for (int i = 2 ; i <= Math.sqrt(SIZE); i++) {
            if (primes[i]) {
                for (int j = i; i * j <= SIZE; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }
}
