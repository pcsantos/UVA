import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        BigInteger sum = new BigInteger("0");
        while (!(in = input.readLine()).equals("0")) {
            BigInteger bi = new BigInteger(in);
            sum = sum.add(bi);
        }
        System.out.println(sum);
        input.close();
    }
}
