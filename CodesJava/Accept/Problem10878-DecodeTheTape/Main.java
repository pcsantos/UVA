import java.util.*;
import java.io.*;

class Main {

    private static Map<String, Character> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
    
        startMap();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            if (!in.contains("_")) {
                in = in.replace("|", "");
                in = in.replace(".", "");
                if (in.equals("    oo o"))
                    System.out.format("\n");
                else
                    System.out.print(map.get(in));
            }
        }
        input.close();
    }

    private static void startMap() {
        String number;
        for (int i = 0; i < 128; i++) {
            number = decimalToBin(i);
            number = number.replace("1", "o");
            number = number.replace("0", " ");
            map.put(number, (char)i);
        }
    }

    private static String decimalToBin(int number) {
        StringBuilder sb = new StringBuilder();
        if (number < 64)
            sb.append("0");
        int v = 1;
        while (v <= number / 2)
            v *= 2;
        int n = number;
        while (v > 0) {
            if (n < v)
                sb.append("0");
            else {
                sb.append("1");
                n -= v;
            }
            v /= 2;
        }
        int size = sb.length();
        StringBuilder eightDigits = new StringBuilder();
        for (int i = 0; i < 8 - size; i++)
            eightDigits.append("0");
        eightDigits.append(sb.toString());
        return eightDigits.toString();
    }
}
