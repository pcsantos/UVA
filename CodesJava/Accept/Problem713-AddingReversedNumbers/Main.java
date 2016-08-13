import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());     
        String in;
        for (int i = 0; i < testCases; i++) {
            in = input.readLine();
            System.out.println(reverseAndSum(in));
        }
        input.close();
    }

    private static String reverseAndSum(String in) {
        StringTokenizer st = new StringTokenizer(in);
        BigInteger bi01 = new BigInteger(new StringBuilder(st.nextToken()).reverse().toString());
        BigInteger bi02 = new BigInteger(new StringBuilder(st.nextToken()).reverse().toString());
        bi01 = bi01.add(bi02);
        bi02 = new BigInteger(new StringBuilder(bi01.toString()).reverse().toString());
        return bi02.toString();
    }
}
