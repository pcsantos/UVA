import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());
        input.readLine();
        for (int i = 1; i <= testCases; i++) {
            if (i > 1)
                System.out.println();
            System.out.format("Case #%d:\n", i);
            in = input.readLine();
            while (in != null && !in.trim().equals("")) {
                System.out.println(decode(in));
                in = input.readLine();
            }
        }
        input.close();
    }

    private static String decode(String in) {
        int count = 1;
        StringTokenizer st = new StringTokenizer(in);
        StringBuilder sb = new StringBuilder();
        String word;
        while (st.hasMoreTokens()) {
            word = st.nextToken();
            if (word.length() >= count) {
                sb.append(String.valueOf(word.charAt(count - 1)));
                count++;
            }
        }
        return sb.toString();
    }
}
