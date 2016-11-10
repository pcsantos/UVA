/*TIME LIMIT*/
import java.util.*;
import java.io.*;
import java.math.*;

class Main {
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            if (i > 0) System.out.println();
            input.readLine();
            int size = Integer.parseInt(input.readLine());
            StringBuilder one = new StringBuilder();
            StringBuilder two = new StringBuilder();
            for (int j = 0; j < size; j++) {
                in = input.readLine();
                StringTokenizer st = new StringTokenizer(in);
                one.append(st.nextToken());
                two.append(st.nextToken());
            }
            System.out.println(sum(one.toString(), two.toString()));
        }
        input.close();
    }

    private static String sum(String one, String two) {
        BigInteger bi1 = new BigInteger(one);
        BigInteger bi2 = new BigInteger(two);
        return bi1.add(bi2).toString();
    }
}
