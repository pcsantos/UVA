import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());     
        for (int i = 1; i <= testCases; i++) {
            in = input.readLine();
            System.out.println("Case " + i + ":" + getSequence(in));
        }
        input.close();
    }

    private static String getSequence(String in) {
    
        char[] array = in.toCharArray();
        StringBuilder out = new StringBuilder();
        
        return null;

    }
}
