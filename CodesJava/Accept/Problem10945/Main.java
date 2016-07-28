import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = input.readLine()).equals("DONE")) {
            if (notBeEaten(line))
                System.out.println("You won't be eaten!");
            else
                System.out.println("Uh oh..");
        }
        input.close();
    }

    private static boolean notBeEaten(String line) {
  
        line = line.toUpperCase();

        String lineWhithoutPunc = line.replace(".", "");
        lineWhithoutPunc = lineWhithoutPunc.replace(",", "");
        lineWhithoutPunc = lineWhithoutPunc.replace("!", "");
        lineWhithoutPunc = lineWhithoutPunc.replace("?", "");
        lineWhithoutPunc = lineWhithoutPunc.replace(" ", "");
    
        return isPalindrome(lineWhithoutPunc);
    }

    private static boolean isPalindrome(String line) {
        
        String reverse = new StringBuffer(line).reverse().toString();
        if (line.equals(reverse))
            return true;
        return false;
    }
}
