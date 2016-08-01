import java.util.*;
import java.io.*;
import java.math.*;

class Main {
    
    private static ArrayList<BigInteger> fib;
    private static int MAX_VALUE = 5000;
    public static void main(String[] args) throws IOException {
        calcFib(); 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while((in = input.readLine()) != null) {
            int value = Integer.parseInt(in);
            System.out.println("The Fibonacci number for " + value +" is " + fib.get(value));
        }

        input.close();
    }

    private static void calcFib() {
    
        fib = new ArrayList<BigInteger>();
        BigInteger bi1 = new BigInteger("0");
        BigInteger bi2 = new BigInteger("1");
        BigInteger aux;

        fib.add(bi1);
        fib.add(bi2);
        for (int i = 2; i <= MAX_VALUE; i++) {
            aux = bi1.add(bi2);
            fib.add(aux);
            bi1 = bi2;
            bi2 = aux;
        }
    }
}
