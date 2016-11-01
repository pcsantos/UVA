import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine())!= null) {
            System.out.print(getOutput(in));
        }
        input.close();
    }

    private static String getOutput(String in) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in);
        String sumOrMult;
        char operator;

        sb.append(in + "\n");
        String nOne = st.nextToken();
        if (isTooBig(nOne))
            sb.append("first number too big\n");
        operator = st.nextToken().charAt(0);
        String nTwo = st.nextToken();
        if (isTooBig(nTwo))
            sb.append("second number too big\n");

        sumOrMult = result(nOne, operator, nTwo);
        if (isTooBig(sumOrMult))
            sb.append("result too big\n");
        return sb.toString();
    }

    private static boolean isTooBig(String number) {
        BigInteger bi = new BigInteger(number);
        BigInteger min = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        if (bi.compareTo(max) <= 0 && bi.compareTo(min) >= 0) return false;
        return true;
    }

    private static String result(String one, char op, String two) {
        BigInteger biOne = new BigInteger(one);
        BigInteger biTwo = new BigInteger(two);
        if (op == '+')        
            return biOne.add(biTwo).toString();
        return biOne.multiply(biTwo).toString();
    }
}
