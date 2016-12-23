import java.util.*;
import java.io.*;

class Main {

    private static int SIZE = 10001;
    private static boolean[] primes = new boolean[SIZE];
    private static ArrayList<Integer> arrList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    
        initPrimes();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int value;
        while ( (value = Integer.parseInt(input.readLine())) != 0 ) {
            System.out.println(printWays(value));    
        }
        input.close();
    }

    private static int printWays(int value) {
        
        int count = 0;
        int sum;
        Object[] arr = arrList.toArray();
        for (int i = 0; i < arr.length; i++) {
            if ((Integer)arr[i] > value) return count;
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += (Integer)arr[j];
                if (sum == value) {
                    count++;
                    break;
                }
                if (sum > value)
                    break;
            }
        }
        return count;
    }

    private static void initPrimes() {
        for (int i = 2; i < SIZE; i++)
            primes[i] = true;
        for (int i = 2; i <= Math.sqrt(SIZE); i++) {
           if (primes[i]) {
                for (int j = i; i * j < SIZE; j++) {
                    primes[i * j] = false;
                }
           }
        }
        for (int i = 1; i < SIZE; i++)
            if (primes[i])
                arrList.add(i);
    }
}
