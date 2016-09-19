import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            if (i > 0)
                System.out.println();
            input.readLine();
            in = input.readLine();
            System.out.println(process(in));
        }
        input.close();
    }

    private static int process(String in) {
        for (int i = 1; i <= in.length() / 2; i++) {
            String sub = in.substring(0, i);
            if (isPeriodic(sub, in, i)) {
                return i;        
            }
        }
        return in.length();
    }

    private static boolean isPeriodic(String sub, String in, int size) {
        String candidate;
        if (in.length() % size != 0)
            return false;
        for (int i = 0; i <= in.length() - size; i+= size) {
            candidate = in.substring(i, i + size);
            if (!candidate.equals(sub))
                return false;
        }
        return true;
    }
}
