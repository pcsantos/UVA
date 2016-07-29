import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int numberTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberTestCases; i++) {
                String word = input.readLine();
                Set<String> output = getOutput(word);
        }
        input.close();
    }

    private static Set<String> getOutput(String word) {
    
        return null;
    }
}
