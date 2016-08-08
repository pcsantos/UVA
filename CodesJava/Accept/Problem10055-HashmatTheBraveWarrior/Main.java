import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(in);
            long firstNumber = Long.parseLong(st.nextToken());
            long secondNumber = Long.parseLong(st.nextToken());
            long result = firstNumber - secondNumber;
            System.out.println(Math.abs(result));
        }
        input.close();
    }
}
