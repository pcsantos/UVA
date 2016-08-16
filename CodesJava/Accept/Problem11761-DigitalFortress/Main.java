import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());     
        String line;
        for (int i = 0; i < testCases; i++) {
            line = input.readLine();
            if (isSquareNumber(line.length())) {
                System.out.println(decryptedText(line));
            } else 
                System.out.println("INVALID");
        }
        input.close();
    }
    
    private static String decryptedText(String in) {
        StringBuilder out = new StringBuilder();
        char[] array = in.toCharArray();
        int limit = (int) Math.sqrt(in.length());
        for (int i = 0; i < limit; i++) {
            for (int j = i; j < array.length; j = j + limit) {
                out.append(array[j]);
            }
        }
        return out.toString();
    }

    private static boolean isSquareNumber(int value) {
        int sqrt = (int) Math.sqrt(value);
        return sqrt*sqrt == value;
    }
}
