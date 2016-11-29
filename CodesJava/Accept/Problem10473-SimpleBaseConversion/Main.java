import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while (!(in = input.readLine()).contains("-")) {
            if (in.contains("x")) {
                System.out.println(convertHexToDecimal(in.substring(2)));
            } else {
                System.out.println("0x" + convertDecimalToHex(Integer.parseInt(in)));
            }
        }
        input.close();
    }

    private static String convertHexToDecimal(String in) {
        int exp = 0;
        int term;
        char[] hexNumber = in.toCharArray();
        int number = 0;
        for (int i = hexNumber.length - 1; i >= 0; i--) {
            term = getValue(hexNumber[i]);
            number += term * pow(16, exp++);
        }
        return String.valueOf(number); 
    }

    private static int getValue(char ch) {
        String symbols = "0123456789ABCDEF";
        return symbols.indexOf(ch);
    }

    private static int pow(int a, int b) {
        int value = 1;
        for (int i = 0; i < b; i++)
            value *= a;
        return value;
    }

    private static String convertDecimalToHex(int number) {
        StringBuilder sb = new StringBuilder();
        int term;
        do {
            term = number % 16;
            if (term < 9)
                sb.append(term);
            else
                sb.append(getSymbol(term));
            number /= 16;
        } while (number > 0);

        return sb.reverse().toString();
    }

    private static char getSymbol(int index) {
        char[] symbol = "0123456789ABCDEF".toCharArray();
        return symbol[index];
    }
}
