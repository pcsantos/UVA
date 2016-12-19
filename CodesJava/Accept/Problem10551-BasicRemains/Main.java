import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ( !(in = input.readLine()).trim().equals("0")) {
            StringTokenizer st = new StringTokenizer(in);
            int base = Integer.parseInt(st.nextToken());
            BigInteger bi01 = new BigInteger(st.nextToken(), base);
            BigInteger bi02 = new BigInteger(st.nextToken(), base);
            System.out.println(bi01.mod(bi02).toString(base));
        }
        input.close();
    }
}
