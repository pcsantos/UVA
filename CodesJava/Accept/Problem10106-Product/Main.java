import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            BigInteger first = new BigInteger(in);
            in = input.readLine();
            BigInteger second = new BigInteger(in);
            System.out.println(first.multiply(second));
        }
        input.close();
    }
}
