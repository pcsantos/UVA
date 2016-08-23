import java.util.*;
import java.io.*;

class Main {

    private static Map<Character, Integer> codes;

    public static void main(String[] args) throws IOException {
        fillTableMap(); 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            System.out.println(getOutput(in)); 
        }
        input.close();
    }

    private static String getOutput(String in) {
        StringBuilder output = new StringBuilder();
        if (codes.get(in.charAt(0)) != 0)
            output.append(codes.get(in.charAt(0)));
        for (int i = 1; i < in.length(); i++) {
            char first = in.charAt(i-1);
            char next = in.charAt(i);
            if (first != next) {
                if (codes.get(first) != codes.get(next) && codes.get(next) != 0) {
                    output.append(codes.get(next));
                }
            }
        }
        return output.toString();
    }

    private static void fillTableMap() {
        codes = new HashMap<Character, Integer>();

        codes.put('A', 0);
        codes.put('E', 0);
        codes.put('I', 0);
        codes.put('O', 0);
        codes.put('U', 0);
        codes.put('Y', 0);
        codes.put('W', 0);
        codes.put('H', 0);
        codes.put('B', 1);
        codes.put('P', 1);
        codes.put('F', 1);
        codes.put('V', 1);
        codes.put('C', 2);
        codes.put('S', 2);
        codes.put('K', 2);
        codes.put('G', 2);
        codes.put('J', 2);
        codes.put('Q', 2);
        codes.put('X', 2);
        codes.put('Z', 2);
        codes.put('D', 3);
        codes.put('T', 3);
        codes.put('L', 4);
        codes.put('M', 5);
        codes.put('N', 5);
        codes.put('R', 6);
    }
}
