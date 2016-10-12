import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            int number = Integer.parseInt(input.readLine());
            int hex = hexToDecimal(number);
            System.out.println(countOnes(decToBinary(number)) + " " + countOnes(decToBinary(hex)));
        }
        input.close();
    }

    private static int countOnes(String number) {
        char[] arr = number.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == '1')
                count++;
        return count;
    }

    private static int hexToDecimal(int value) {
        int decimal = 0;
        int i = 0;
        do {
            decimal += (value % 10) * square(16, i++);
            value /= 10;
        } while (value > 0);
        return decimal;
    }

    private static String decToBinary(int value) {
        int v = 1;
        StringBuffer sb = new StringBuffer();
        while (v <= value / 2)
            v *= 2;
        int n = value;
        while (v > 0) {
            if (n < v)
                sb.append("0");
            else {
                sb.append("1");
                n -= v;
            }
            v /= 2;
        }
        return sb.toString();
    }

    private static int square(int x, int y) {
        int value = 1;
        for (int i = 0; i < y; i++)
            value *= x;
        return value;
    }
}
