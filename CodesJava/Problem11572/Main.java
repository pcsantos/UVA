import java.util.*;
import java.io.*;

class Main {

    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
        String in;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            int nElements = Integer.parseInt(input.readLine());
            for (int j = 0; j < nElements; j++) {
                in = input.readLine();
                set.add(in);
            }
            System.out.println(set.size());
            set.clear();
        }
        input.close();
    }
}
