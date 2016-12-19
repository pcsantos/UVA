import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int cases = 1;
        while ( !(in = input.readLine()).trim().equals("0 0")) {
            StringTokenizer st = new StringTokenizer(in);
            int itens = Integer.parseInt(st.nextToken());
            BigInteger friends = new BigInteger(st.nextToken());
            BigInteger total = BigInteger.ZERO;
            for (int i = 0; i < itens; i++) {
                total = total.add(new BigInteger(input.readLine()));
            }
            System.out.println("Bill #" + (cases++) + " costs " + total +": each friend should pay " + total.divide(friends));
            System.out.println();
        }
        input.close();
    }
}
