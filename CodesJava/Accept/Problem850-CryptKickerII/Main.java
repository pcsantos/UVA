import java.util.*;
import java.io.*;

class Main {

    private static HashMap<Character, Character> map = new HashMap<Character, Character>();
    private static String keyPhrase = "the quick brown fox jumps over the lazy dog";

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());
        input.readLine();
        for (int i = 0; i < testCases; i++) {
            if (i > 0)
                System.out.println();
            ArrayList<String> lines = new ArrayList<>();
            in = input.readLine();
            boolean patternNotFound = true;
            while (in != null && !in.equals("")) {
                lines.add(in);
                if (in.length() == keyPhrase.length() && patternNotFound) {
                    if(checkIfKey(in))
                        patternNotFound = false;
                }
                in = input.readLine();
            }
            if (patternNotFound)
                System.out.println("No solution.");
            else
                printOutput(lines);
        }
        input.close();
    }

    private static boolean checkIfKey(String in) {
        StringTokenizer key = new StringTokenizer(keyPhrase);
        StringTokenizer st = new StringTokenizer(in);
        while(key.hasMoreTokens()) {
            if(key.nextToken().length() != st.nextToken().length())
                return false;
        }
        setMap(in);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            sb.append(map.get(in.charAt(i)));       
        }
        if (sb.toString().equals(keyPhrase))
            return true;
        map.clear();
        return false;
    }

    private static void setMap(String in) {
        for (int i = 0; i < in.length(); i++) {
            map.put(in.charAt(i), keyPhrase.charAt(i));
        }
    }

    private static void printOutput(ArrayList<String> lines) {
        for (String line : lines) {
            for (int i = 0; i < line.length(); i++) {
                System.out.print(map.get(line.charAt(i)));
            }
            System.out.println();
        }
    }
}
