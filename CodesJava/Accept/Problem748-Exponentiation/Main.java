import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine())!= null) {
            StringTokenizer st = new StringTokenizer(in);
            BigDecimal bd = new BigDecimal(st.nextToken());
            int exp = Integer.parseInt(st.nextToken());
            System.out.println(getOutput(bd.pow(exp).stripTrailingZeros().toPlainString()));
        }
        input.close();
    }

    private static String getOutput(String in) {
        for (int i = 0; i < in.length(); i++)
            if (in.charAt(i) != '0')
                return in.substring(i);
        return in;
    }
}
