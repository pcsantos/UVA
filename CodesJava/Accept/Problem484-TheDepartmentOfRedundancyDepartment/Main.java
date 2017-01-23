import java.util.*;
import java.io.*;

class Main {

    private static LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null)
            processNumbers(in);
        for (Integer key : map.keySet()) 
            System.out.println(key + " " + map.get(key));
        input.close();
    }

    private static void processNumbers(String in) {
        StringTokenizer st = new StringTokenizer(in);
        int key, value;
        while (st.hasMoreTokens()) {
            key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)) {
                value = map.get(key);
                map.put(key, ++value);
            } else
                map.put(key, 1);
        }
    }
}
