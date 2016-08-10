import java.util.*;
import java.io.*;

class Main {

    private static int HIGH = 1000000;
    private static boolean[] primes = new boolean[HIGH + 1];
    private static int[] primeDigits = new int[HIGH + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder(25000);
        int testCases = Integer.parseInt(input.readLine());
        StringTokenizer st;
        String in;
        sieveOfErastosthenes();
        countDigits();
        long start = System.currentTimeMillis();
        for (int i = 0; i < testCases; i++) {
            in = input.readLine();
            st = new StringTokenizer(in);
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            int out = primeDigits[high] - primeDigits[low];
            stringBuilder.append(out+"\n");
            if (stringBuilder.length() > 24900) {
                output.write(stringBuilder.toString());
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        output.write(stringBuilder.toString());
        output.flush();
        output.close();
        input.close();
    }

    private static int sumDigits(int number) {
        String n = String.valueOf(number);
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += Integer.parseInt(n.charAt(i) + "");
        }
        return sum;
    }
    
    private static void countDigits() {
        int count = 0;
        primeDigits[0] = 0;
        for (int i = 1; i <= HIGH; i++) {
            if (primes[i]) {
                if (primes[sumDigits(i)]) {
                    count++;
                }
            }
            primeDigits[i] = count;
        }
    }
    private static void sieveOfErastosthenes() {

        for (int i = 2; i <= HIGH; i++) {
            primes[i] = true;
        }

        for (long i = 2; i <= Math.sqrt(HIGH); i++) {
            if (primes[(int)i]) {
                for (long j = i; i*j <= HIGH; j++) {
                    primes[(int)(i*j)] = false;
                }
            }
        }
    }
}
