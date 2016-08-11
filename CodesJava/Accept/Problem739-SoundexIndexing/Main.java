import java.util.*;
import java.io.*;

class Main {

    private static Map<Character, Integer> codes;
    private static int CODE_SIZE = 4;

    public static void main(String[] args) throws IOException {
        fillTableMap(); 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        System.out.format("%-8s %-24s %s\n", "", "NAME", "SOUNDEX CODE");
        while ((in = input.readLine()) != null) {
            String output = getOutput(in); 
            System.out.format("%-8s %-24s %s\n", "", in, output);
        }
        System.out.format("%-18s %s\n", "", "END OF OUTPUT");
        input.close();
    }

    private static String getOutput(String in) {
        StringBuilder output = new StringBuilder(in.charAt(0));
        for (int i = 1; i < in.length(); i++) {
            String first = in.charAt(i-1);
            String next = in.charAt(i);
            if (!first.equals(next)) {
                if (codes.get(first) != codes.get(next) && codes.get(next) != 0) {
                    output.append(codes.get(next));
                }
            }
        }
        
        if (output.length() < CODE_SIZE) {
            for (int i = output.length(); i < CODE_SIZE; i++) {
                output.append(0);       
            }
        } else {
            output.setLength(CODE_SIZE);
        }
        return output.toString();
    }

    private static void fillTableMap() {
        codes = new HashMap<String, Integer>();

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
