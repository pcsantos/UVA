import java.util.*;
import java.io.*;

class Main {

    private static final int HEX = 16;
    private static final int MAX_LEADING_ZEROS = 13;

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int firstDec;
        int secondDec;
        int testCases = Integer.parseInt(input.readLine().trim());
        for (int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine().trim());
            String firstHex = st.nextToken();
            String operator = st.nextToken();
            String secondHex = st.nextToken();
            firstDec = convertToDecimal(firstHex);
            secondDec = convertToDecimal(secondHex);
            if (operator.equals("+"))
                System.out.println(convertToBin(firstDec) + " + " + convertToBin(secondDec) + " = " + (firstDec + secondDec));
            else
                System.out.println(convertToBin(firstDec) + " - " + convertToBin(secondDec) + " = " + (firstDec - secondDec));
        }
        input.close();
    }

    private static String convertToBin(int number) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(number % 2);
            number /= 2;
        } while (number > 0);
        for (int i = sb.length(); i < MAX_LEADING_ZEROS; i++)
            sb.append("0");
        return sb.reverse().toString();
    }

    private static int convertToDecimal(String number) {
        int exp = 0;
        char[] n = number.toCharArray();
        int term;
        int value = 0;
        for (int i = n.length - 1; i >= 0; i--) {
            term = getValue(n[i]);
            value += term * pow(HEX, exp++);
        }
        return value;
    }

    private static int pow(int a, int b) {
        int value = 1;
        for (int i = 0; i < b; i++)
            value *= a;
        return value;
    }

    private static int getValue(char ch) {
        String symbols = "0123456789ABCDEF";
        return symbols.indexOf(ch);
    }
}
