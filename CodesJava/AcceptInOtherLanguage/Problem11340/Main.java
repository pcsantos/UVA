import java.util.*;
import java.io.*;

class Main {

    private static Map<Character, Integer> tableValues = new HashMap<Character, Integer>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in), 100001);    
        int casesTest = Integer.parseInt(input.readLine());
        for (int i = 0; i < casesTest; i++) {
            int numberOfPayableChars = Integer.parseInt(input.readLine());
            for (int j = 0; j < numberOfPayableChars; j++) {
                String in = input.readLine();
                StringTokenizer st = new StringTokenizer(in);
                String key = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                tableValues.put(key.charAt(0), value);
            }
            int qtdLines = Integer.parseInt(input.readLine());
            float value = 0;
            for (int j = 0; j < qtdLines; j++) {
                String in = input.readLine();
                value += getPartialValue(in);
            }
            System.out.format("%.2f$\n", value/100);
            tableValues.clear();
        }
        input.close();
    }

    private static float getPartialValue(String in) {
    
        float value = 0;
        for (int i = 0; i < in.length(); i++) {
            char key = in.charAt(i);
            if (tableValues.containsKey(key))
                value += tableValues.get(key);
        }
        return value;
    }
}
