import java.util.*;
import java.io.*;
import java.math.*;

class Main {
    
    private static final int MAX_VALUE = 4782;
    private static BigInteger[] arr = new BigInteger[MAX_VALUE];

    public static void main(String[] args) throws IOException {
        initBigArr(); 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while ((in = input.readLine()) != null) {
            System.out.println(arr[Integer.parseInt(in)]);
        }
        input.close();
    }

    private static void initBigArr() {
        arr[1] = BigInteger.ONE;
        arr[2] = BigInteger.ONE;
        for (int i = 3; i < MAX_VALUE; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }
    }
}
