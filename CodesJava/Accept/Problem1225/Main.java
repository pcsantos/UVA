import java.util.*;
import java.io.*;

class Main {

    private static int[] digits = new int[10];

    public static void main(String[] args) throws IOException {
    
        clearDigitsArray();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            int limit = Integer.parseInt(input.readLine());
            countDigits(limit);
            String output = getOutput();
            System.out.println(output);
            clearDigitsArray();
        }
        input.close();
    }

    private static String getOutput() {
        StringBuilder out = new StringBuilder("");
        for (int i = 0; i < 10; i++) {
            out.append(digits[i]+" ");
        }
        return out.toString().trim();
    }

    private static void countDigits(int limit) {
        for (int i = 1; i <= limit; i++) {
            String number = String.valueOf(i);
            for (int j = 0; j < number.length(); j++) {
                int index = Integer.parseInt(number.charAt(j)+"");
                digits[index]++;
            }
        }
    }

    private static void clearDigitsArray() {
        for (int i = 0; i < 10; i++) {
            digits[i] = 0;
        }
    }
}
