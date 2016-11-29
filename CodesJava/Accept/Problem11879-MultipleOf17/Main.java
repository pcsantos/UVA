import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while (!(in = input.readLine()).trim().equals("0")) {
            System.out.println(getResult(in));
        }
        input.close();
    }

    private static int getResult(String in) {
        if (in.length() == 1)
            return 0;
        BigInteger biOne = new BigInteger(in.substring(0, (in.length() - 1)));
        BigInteger biTwo = new BigInteger(in.substring(in.length() - 1));
        biTwo = biTwo.multiply(new BigInteger("5"));

        BigInteger[] result = biOne.subtract(biTwo).divideAndRemainder(new BigInteger("17"));
    
        if (result[1].compareTo(BigInteger.ZERO) == 0)
            return 1;
        return 0;
    }
}
