import java.util.*;
import java.io.*;
import java.math.*;

class Main {
    private static BigInteger[] array;
    private static int MAX_VALUE = 367;
    private static int[] digits = new int[10];

    public static void main(String[] args) throws IOException {
    	
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        calcFat();
        while (!(in = input.readLine()).equals("0")) {
            int number = Integer.parseInt(in);
            countDigits(number);
            String output = getOutput(number);
            System.out.println(output);
            clearDigitsArray();
        }
        input.close();
    }

    private static String getOutput(int number) {
        StringBuilder out = new StringBuilder("");
        out.append(number + "! --\n");
        for (int i = 0; i < 10; i++) {
            out.append(String.format("%2s (%d) %4d","",  i, digits[i]));
            if (i == 4)
                out.append("\n");
        }
        return out.toString();
    }

    private static void countDigits(int number) {
        String n = array[number].toString();
        for (int j = 0; j < n.length(); j++) {
            int index = Integer.parseInt(n.charAt(j)+"");
            digits[index]++;
        }
    }

    private static void clearDigitsArray() {
        for (int i = 0; i < 10; i++) {
            digits[i] = 0;
        }
    }
    private static void calcFat() {
        array = new BigInteger[MAX_VALUE];

        array[0] = new BigInteger("1");
        for (int i = 1; i < MAX_VALUE; i++) {
            BigInteger aux = new BigInteger(i+"");
            array[i] = array[i-1].multiply(aux);
        }
    }
}
