import java.util.*;
import java.io.*;

class Main {

    private static TreeMap<String, Integer> map = new TreeMap<String, Integer>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());
        input.readLine();
        int trees;
        int value;
        for (int i = 0; i < testCases; i++) {
            if (i > 0)
                System.out.println();
            trees = 0;
            in = input.readLine();
            while ((in != null) && (!in.trim().equals(""))) {
                if (map.containsKey(in)) {
                    value = map.get(in);
                    map.put(in, ++value);
                } else {
                     map.put(in, 1);
                }
                trees++;
                in = input.readLine();
            }
            for (String key: map.keySet())
                System.out.printf("%s %.4f\n", key, ((float)map.get(key)/trees) * 100);
            map.clear();
        }
        input.close();
    }
}
