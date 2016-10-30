import java.util.*;
import java.math.*;
class Main {

    public static void main(String[] args) {
        BigInteger bi = BigInteger.ONE;
        BigInteger aux = new BigInteger("99999999999999999");
        BigInteger i = BigInteger.ONE;
    
        while (bi.compareTo(aux) < 0) {
            System.out.println(bi);       
            bi = bi.add(i);
            i = i.add(BigInteger.ONE);
        }
    }
}
