import java.util.*;
import java.io.*;

class Main {

    private static Map<Character, Integer> map = new HashMap<Character, Integer>();

    public static void main(String[] args) throws IOException {
   
        startMap();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while (!(in = input.readLine()).equals("*")) {
            System.out.println(goodMeasuresNumber(in));
        }
        input.close();
    }

    private static int goodMeasuresNumber(String in) {
        StringTokenizer st = new StringTokenizer(in, "/");
        int count = 0;
        while(st.hasMoreTokens()) {
            char [] arr = st.nextToken().toCharArray();
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += map.get(arr[i]);
            }
            if ((sum % 64)  ==  0 && sum / 64 <= 1)
                count++;
        }
        return count;
    }

    private static void startMap() {
        map.put('W', 64);
        map.put('H', 32);
        map.put('Q', 16);
        map.put('E', 8);
        map.put('S', 4);
        map.put('T', 2);
        map.put('X', 1);
    }
}
