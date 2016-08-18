import java.util.*;
import java.io.*;

class Main {
    
    private static final int SIZE = 10;
    private static int[] firstNumber = new int[SIZE];
    private static int[] secondNumber = new int[SIZE];
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while (!(in = input.readLine()).equals("0 0")) {
            setNumbers(in);
            int carry = carryOperations();
            switch (carry) {
                case 0 :
                    System.out.println("No carry operation.");
                    break;
                case 1 :
                    System.out.println("1 carry operation.");
                    break;
                default : 
                    System.out.println(carry +" carry operations.");
                    break;
            } 
        }
        input.close();
    }
    
    private static int carryOperations() {
        
        int totalCarry = 0;
        int carry = 0;
        for (int i = SIZE - 1; i >= 0; i--) {
            if (firstNumber[i] + secondNumber[i] + carry > 9) {
                totalCarry++;
                carry = 1;
            } else
                carry = 0;
        }
        return totalCarry;
    }

    private static void setNumbers(String in) {
        StringTokenizer st = new StringTokenizer(in);
        String fNumber = st.nextToken();
        String sNumber = st.nextToken();
        StringBuilder sb01 = new StringBuilder(leftZeros(SIZE - fNumber.length()));
        sb01.append(fNumber);
        char[] array = sb01.toString().toCharArray();
        for (int i = 0; i < SIZE; i++)
            firstNumber[i] = Integer.parseInt(String.valueOf(array[i]));
        StringBuilder sb02 = new StringBuilder(leftZeros(SIZE - sNumber.length()));
        sb02.append(sNumber);
        array = sb02.toString().toCharArray();
        for (int i = 0; i < SIZE; i++)
            secondNumber[i] = Integer.parseInt(String.valueOf(array[i]));
    }

    private static String leftZeros(int limit) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < limit; i++)
            str.append("0");
        return str.toString();
    }
}
