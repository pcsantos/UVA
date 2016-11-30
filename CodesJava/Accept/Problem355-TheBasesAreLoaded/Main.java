import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while ((in = input.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(in);
            int currentBase = Integer.parseInt(st.nextToken());
            int nextBase = Integer.parseInt(st.nextToken());
            String number = st.nextToken();
            BigInteger bi = convertToDecimal(number, currentBase);
            if (bi.compareTo(BigInteger.ZERO) >= 0) {
                String newNumber = convertDecimalToBaseX(bi, nextBase);
                System.out.println(number + " base " + currentBase + " = " + newNumber + " base " + nextBase);
            } else {
                System.out.println(number + " is an illegal base " + currentBase + " number");
            }
        }
        input.close();
    }

    private static String convertDecimalToBaseX(BigInteger bi, int nextBase) {
        BigInteger aux = new BigInteger(String.valueOf(nextBase));
        BigInteger[] result;
        StringBuilder sb = new StringBuilder();
        do {
            result = bi.divideAndRemainder(aux);
            String symbol = getSymbol(result[1].intValue());           
            sb.append(symbol);
            bi = result[0];
        } while (bi.compareTo(BigInteger.ZERO) > 0);

        return sb.reverse().toString();
    }

    private static String getSymbol(int index) {
        char[] symbols = "0123456789ABCDEF".toCharArray();
        return String.valueOf(symbols[index]);
    }

    private static BigInteger convertToDecimal(String number, int base) {
        BigInteger bi = BigInteger.ZERO;
        int exp = 0;
        int term;
        char[] arr = number.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            term = getValue(arr[i]);
            if(term > base - 1)
                return new BigInteger("-1");;
            bi = bi.add(new BigInteger(String.valueOf(term)).multiply(new BigInteger(getPow(base, exp++))));
        }
        return bi;
    }

    private static String getPow(int a, int b) {
        long value = 1;
        for (int i = 0; i < b; i++)
            value *= a;
        return String.valueOf(value);
    }

    private static int getValue(char ch) {
        String symbols = "0123456789ABCDEF";
        if (symbols.contains(String.valueOf(ch)))
            return symbols.indexOf(ch);
        return 17;
    }
}
