import java.util.*;
import java.io.*;
import java.math.*;
class Main {
    
    private static BigInteger[] factorial = new BigInteger[10001];

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        fat();
        while ((in = input.readLine()) != null) {
            int out = getDigit(in);
            System.out.format("%5s -> %d\n", in, out);
        }
        input.close();
    }

    private static int getDigit(String in) {
    
        int number = Integer.parseInt(in);
        String fac = factorial[number].toString();
        int index = 0;
        for (int i = fac.length() - 1; i >= 0; i--) {
            if (fac.charAt(i) != '0'){
                index = i;
                break;
            }
        }
        return Integer.parseInt(fac.charAt(index) + "");
    }

    private static void fat() {
        BigInteger aux;
        factorial[0] = new BigInteger("1");
        for (int i = 1; i < 10001; i++) {
            aux = new BigInteger(i + "");
            factorial[i] = factorial[i-1].multiply(aux);
        }
    }
}
