import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
        String in;
        while ( !(in = input.readLine()).trim().equals("0 0") ) {
            StringTokenizer st = new StringTokenizer(in);
            String missDigit = st.nextToken();
            String number = st.nextToken();
            number = number.replace(missDigit, "");
            if (number.length() == 0)
                System.out.println("0");
            else
                System.out.println(new BigInteger(number));
        }
        input.close();
    }
}
