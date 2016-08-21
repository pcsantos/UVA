import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            int number = Integer.parseInt(in);
            System.out.println(number + " converts to " + Integer.reverseBytes(number));
        }
        input.close();
    }
}
