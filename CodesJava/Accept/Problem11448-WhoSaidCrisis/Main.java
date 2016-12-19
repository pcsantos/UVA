import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            BigInteger biA = new BigInteger(st.nextToken());
            BigInteger biB = new BigInteger(st.nextToken());
            System.out.println(biA.subtract(biB));
        }
        input.close();
    }
}
