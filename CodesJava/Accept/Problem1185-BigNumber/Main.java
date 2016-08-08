import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());     
        for (int i = 0 ; i < testCases; i++) {
            int number = Integer.parseInt(input.readLine());
            long output = numberOfDigits(number);
            System.out.println(output);
        }
        input.close();
    }

    private static long numberOfDigits(int number) {
  
        if (number == 1)
            return 1;
        double n = 0.5 * (Math.log10(2 * Math.PI * number)) + number * Math.log10(number / Math.E) + 1;
        long value = (long) Math.floor(n);
        return value;
    }
}
