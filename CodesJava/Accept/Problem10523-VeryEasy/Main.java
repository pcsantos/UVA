import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ( (in = input.readLine()) != null ) {
            StringTokenizer st = new StringTokenizer(in.trim());
            int N = Integer.parseInt(st.nextToken());
            BigInteger A = new BigInteger(st.nextToken());
            BigInteger sum = BigInteger.ZERO;
            for (int i = 1; i <= N; i++) {
                sum = sum.add((new BigInteger(String.valueOf(i))).multiply(A.pow(i)));
            }
            System.out.println(sum);
        }
        input.close();
    }
}
