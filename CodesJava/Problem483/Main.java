import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            String output = reverseWords(in);
            System.out.println(output);
        }
        input.close();
    }

    private static String reverseWords(String in) {
   
        String str = "";
        StringBuilder output = new StringBuilder("");
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) != ' ') {
                str += in.charAt(i);
            } else if (!str.equals("")) {
                String partialOut = new StringBuilder(str).reverse().toString();
                output.append(partialOut + " ");
                str = "";
            } else {
                output.append(" ");
            }                
        }
        if (!str.equals("")) {
            String partialOut = new StringBuilder(str).reverse().toString();
            output.append(partialOut);
        }

        return output.toString();
    }
}
