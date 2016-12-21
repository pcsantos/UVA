import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        BigInteger aux = new BigInteger("2148");
        boolean flag;
        boolean firstCase = false;
        while ( !(in = input.readLine()).trim().equals("0") ) {
            flag = true;
            if (firstCase)
                System.out.println();
            firstCase = true;
            System.out.println(in);
            BigInteger toLeap = new BigInteger(in);
            BigInteger bi = new BigInteger(in);
            if (bi.compareTo(aux) < 0) {
                System.out.println("No ghost will come in this year");
                continue;
            }

            bi = bi.subtract(aux);
            if (bi.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("Ghost of Tanveer Ahsan!!!");
                flag = false;
            }
            if (bi.mod(new BigInteger("5")).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("Ghost of Shahriar Manzoor!!!");
                flag = false;
            }
            if (bi.mod(new BigInteger("7")).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("Ghost of Adrian Kugel!!!");
                flag = false;
            }
            if (bi.mod(new BigInteger("11")).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("Ghost of Anton Maydell!!!");
                flag = false;
            }
            if (bi.mod(new BigInteger("15")).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("Ghost of Derek Kisman!!!");
                flag = false;
            }
            if (bi.mod(new BigInteger("20")).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("Ghost of Rezaul Alam Chowdhury!!!");
                flag = false;
            }
            if (bi.mod(new BigInteger("28")).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("Ghost of Jimmy Mardell!!!");
                flag = false;
            }
            if (bi.mod(new BigInteger("36")).compareTo(BigInteger.ZERO) == 0) {
                System.out.println("Ghost of Monirul Hasan!!!");
                flag = false;
            }
            if ( (toLeap.mod(new BigInteger("400")).compareTo(BigInteger.ZERO) == 0) ||
                (toLeap.mod(new BigInteger("4")).compareTo(BigInteger.ZERO) == 0 &&
                toLeap.mod(new BigInteger("100")).compareTo(BigInteger.ZERO) != 0)) {
                System.out.println("Ghost of K. M. Iftekhar!!!");
                flag = false;
            }
            if (flag)
                System.out.println("No ghost will come in this year");
        }
        input.close();
    }
}
