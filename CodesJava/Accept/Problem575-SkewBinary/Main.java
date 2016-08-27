import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while (!(in = input.readLine()).trim().equals("0")) {
            System.out.println(getDecimal(in.trim()));
        }
        input.close();
    }

    private static int getDecimal(String in) {
        char[] array = in.toCharArray();
        int size = array.length;
        int decimal = 0;
        for (int i = 0; i < array.length; i++) {
            decimal += Integer.parseInt(String.valueOf(array[i])) * (Math.pow(2.0, size--) - 1);
        }
        return decimal;
    }
}
