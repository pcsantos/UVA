import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    private static final int SIZE = 1000000000;
    private static BigInteger[] arr = new BigInteger[SIZE];

    public static void main(String[] args) throws IOException {
        initBigArr(); 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
           in = input.readLine();
           System.out.println(getOut(in));
        }
        input.close();
    }

    private static String getOut(String in) {
        StringTokenizer st = new StringTokenizer(in);
        BigInteger rangeA = new BigInteger(st.nextToken());
        BigInteger rangeB = new BigInteger(st.nextToken());
        int rangeN = Integer.parseInt(st.nextToken());
        int rangeM = Integer.parseInt(st.nextToken());
        return null;
    }

    private static void initBigArr() {
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;
        for (int i = 2; i < SIZE; i++)
            arr[i] = arr[i - 1].add(arr[i - 2]);
    }
}
