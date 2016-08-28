import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        BigInteger eleven = new BigInteger("11");
        String in;
        while (!(in = input.readLine()).trim().equals("0")) {
            BigInteger bi = new BigInteger(in);
            BigInteger[] val = bi.divideAndRemainder(eleven);
            int value = val[1].intValue();
            if (value == 0) {
                System.out.println(in + " is a multiple of 11.");
            } else
                System.out.println(in + " is not a multiple of 11.");
        }
        input.close();
    }
}
