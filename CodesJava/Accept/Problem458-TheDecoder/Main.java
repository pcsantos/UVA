import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));    
        OutputStreamWriter out = new OutputStreamWriter(System.out, "ISO-8859-1");
        String in;     
        while ((in = input.readLine()) != null) {
            out.write(decode(in) + "\n");
            out.flush();
        }
        out.close();
        input.close();
    }

    private static String decode(String in) {
        char[] arr = in.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append((char)(arr[i] - 7));
        }
        return sb.toString();
    }
}
