import java.util.*;
import java.io.*;

class Main {

    private static int HIGH = 1000000;
    private static boolean[] primes = new boolean[HIGH + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder(25000);
        int testCases = Integer.parseInt(input.readLine());
        String in;
        sieveOfErastosthenes();
        long start = System.currentTimeMillis();
        for (int i = 0; i < testCases; i++) {
            in = input.readLine();
            StringTokenizer st = new StringTokenizer(in);
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            int out = countNumberOfPrimeDigits(low, high);
            stringBuilder.append(out+"\n");
        }
        output.write(stringBuilder.toString());
        output.write("Total: " + (System.currentTimeMillis() - start)/1000);
        output.flush();
        output.close();
        input.close();
    }

    private static int countNumberOfPrimeDigits(int low, int high) {
    
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (primes[i]) {
               if (primes[sumDigits(i)])
                   count++;
            }
        }
        return count;
    }


    private static int sumDigits(int number) {
    
        String n = String.valueOf(number);
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += Integer.parseInt(n.charAt(i) + "");
        }
        return sum;
    }

    private static void sieveOfErastosthenes() {

        primes[2] = true;
        for (int i = 3; i <= HIGH; i++) {
            if (i % 2 != 0)
                primes[i] = true;
        }

        for (long i = 3; i <= HIGH; i += 2) {
            if (primes[(int)i]) {
                for (long j = i; i*j <= HIGH; j++) {
                    primes[(int)(i*j)] = false;
                }
            }
        }
    }
}
