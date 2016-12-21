import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in, aux;
        while ( (in = input.readLine()) != null ) {
            BigInteger bi = new BigInteger(in);
            bi = bi.pow(2);
            if (in.equals("0") || in.equals("1")) {
                System.out.println("Not an Automorphic number.");
                continue;
            }
            if (bi.toString().length() >= in.length())
                aux = bi.toString().substring(bi.toString().length() - in.length());
            else
                aux = "";
            if (!aux.equals(in))
                System.out.println("Not an Automorphic number.");
            else 
                System.out.println("Automorphic number of " + in.length()+ "-digit.");
        }
        input.close();
    }
}
