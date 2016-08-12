import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in = input.readLine();
        StringTokenizer st = new StringTokenizer(in);
        System.out.println("PERFECTION OUTPUT");
        while(st.hasMoreTokens()) {
            in = st.nextToken();
            if (!in.equals("0")) {
                System.out.format("%5s  %s\n", in, numberIs(in));       
            }
        }
        System.out.println("END OF OUTPUT");
        input.close();
    }

    private static String numberIs(String in) {
        int number = Integer.parseInt(in);
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0)
                sum += i;
        }
        if (sum == number)
            return "PERFECT";
        else if (sum > number)
            return "ABUNDANT";
        else
            return "DEFICIENT";
    }
}
