import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            if (i > 0)
                System.out.println();
            input.readLine();
            in = input.readLine();
            process(in);
        }
        input.close();
    }

    private static void process(String in) {
        BigInteger N = new BigInteger(in);
        BigInteger s1, s2, aux;

        s1 = BigInteger.ONE;
        aux = new BigInteger("9876543210");
        while (aux.divide(N).compareTo(s1) >= 0) {
            s2 = s1.multiply(N);
            if (noRepetition(s2.toString()) && noRepetition(s1.toString()))
                System.out.println(s2 + " / " + s1 + " = " + N);
            s1 = s1.add(BigInteger.ONE);
        }
    }
    
    private static boolean noRepetition(String in) {
        boolean[] numbers = new boolean[10];
        char[] arr = in.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int index = Integer.parseInt(String.valueOf(arr[i]));
            if (!numbers[index])
                numbers[index] = true;
            else
                return false;
        }
        return true;
    }
}
