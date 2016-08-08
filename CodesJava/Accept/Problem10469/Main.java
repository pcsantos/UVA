import java.util.*;
import java.io.*;

class Main {

    private static final int MAX_BITS = 32;

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(in);
            int firstNumber = Integer.parseInt(st.nextToken());       
            int secondNumber = Integer.parseInt(st.nextToken());
            int[] fNumber = convertToBinaryWith32Bits(firstNumber);
            int[] sNumber = convertToBinaryWith32Bits(secondNumber);
            int[] result =  new int[MAX_BITS];
            for (int i = 0 ; i < MAX_BITS; i++) {
                if (fNumber[i] == sNumber[i])
                    result[i] = 0;
                else
                    result[i] = 1;
            }
            int decimalNumber = getDecimal(result);
            System.out.println(decimalNumber);
        }
        input.close();
    }

    private static int getDecimal(int[] result) {
    
        int value = result[MAX_BITS - 1];
        int aux = 2;
        for (int i = MAX_BITS - 2; i >= 0; i--) {
            value += aux * result[i];
            aux *= 2;
        }
        return value;
    }

    private static int[] convertToBinaryWith32Bits(int number) {
        StringBuilder bNumber = new StringBuilder(); 
        int value = 1;
        while (value <= number/2)
            value = 2 * value;
        int n = number;
        while (value > 0) {
            if (n < value) {
                bNumber.append("0");
            } else {
                bNumber.append("1");
                n -= value;
            }
            value = value/2;
        }
        return changeToArray(bNumber.toString());
    }

    private static int[] changeToArray(String number) {
    
        int[] array = new int[MAX_BITS];
        int j = 0;
        for (int i = MAX_BITS - number.length(); i < MAX_BITS; i++) {
                array[i] = Integer.parseInt(number.charAt(j++) + "");
        }
        return array;
    }
}
