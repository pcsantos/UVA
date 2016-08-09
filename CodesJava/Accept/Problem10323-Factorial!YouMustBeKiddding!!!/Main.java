import java.util.*;
import java.io.*;

class Main {
        
    private static final long UNDERFLOW = 10000;

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            long number;
            if (in.contains("-")) {
                in = in.replace("-", "");
                number = Long.parseLong(in);
                if (number % 2 == 0)
                    System.out.println("Underflow!");
                else
                    System.out.println("Overflow!");

            } else {
                number = Long.parseLong(in);
                System.out.println(fat(number));
            }
        }
        input.close();
    }

    private static String fat(long number) {
        
        if (number > 13)
            return "Overflow!";
        long fat = 1;
        for (int i = 1; i <= number; i++)
            fat = fat*i;
        if (fat < UNDERFLOW)
            return "Underflow!";
        else
            return String.valueOf(fat);
    }
}
