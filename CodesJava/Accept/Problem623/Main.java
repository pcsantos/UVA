import java.util.*;
import java.io.*;
import java.math.*;

class Main {
    
    private static BigInteger[] array;
    private static int MAX_VALUE = 1001;
    public static void main(String[] args) throws IOException {
    
        calcFat();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            int number = Integer.parseInt(in);
            System.out.println(number + "!");
            System.out.println(array[number]);
        }
        input.close();
    }

    private static void calcFat() {
        array = new BigInteger[MAX_VALUE];

        array[0] = new BigInteger("1");
        for (int i = 1; i < MAX_VALUE; i++) {
            BigInteger aux = new BigInteger(i+"");
            array[i] = array[i-1].multiply(aux);
        }
    }
}
