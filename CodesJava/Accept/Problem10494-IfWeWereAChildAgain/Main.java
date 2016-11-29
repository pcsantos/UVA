import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while ((in = input.readLine()) != null) {
                System.out.println(getResult(in));
        }
        input.close();
    }

    private static String getResult(String in) {
        StringTokenizer st = new StringTokenizer(in);
        BigInteger firstN = new BigInteger(st.nextToken());
        char operator = st.nextToken().toString().charAt(0);
        BigInteger secondN = new BigInteger(st.nextToken());
        BigInteger[] result = firstN.divideAndRemainder(secondN);
        if (operator == '%')
            return result[1].toString();
        return result[0].toString();
    }
}
