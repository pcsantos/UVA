import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        String out;
        while (!(in = input.readLine()).trim().equals("0")) {
             out = getOutput(in);
             System.out.println(out);
        }
        input.close();
    }

    private static String getOutput(String in) {
        StringBuilder out = new StringBuilder();
        String line;
        int group;
        StringTokenizer st = new StringTokenizer(in);
        int size = Integer.parseInt(st.nextToken());
        line = st.nextToken().trim();
        group = line.length() / size;
        for (int i = 0; i <= line.length() - group; i += group) {
            out.append(reverse(line.substring(i, i + group)));
        }
        return out.toString();
    }

    private static String reverse(String in) {
        StringBuilder sb = new StringBuilder(in).reverse();
        return sb.toString();
    }
}
