import java.util.*;
import java.io.*;

class Main {

    private static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    public static void main(String[] args) throws IOException {
        mapKeys();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 1; i <= testCases; i++) {
            in = input.readLine();
            System.out.println("Case #" + i + ": " + countKeys(in));
        }
        input.close();
    }

    private static int countKeys(String in) {
        int sum = 0;
        for (int i = 0; i < in.length(); i++) {
            sum += map.get(in.charAt(i));
        }
        return sum;
    }

    private static void mapKeys() {
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        map.put('d', 1);
        map.put('e', 2);
        map.put('f', 3);
        map.put('g', 1);
        map.put('h', 2);
        map.put('i', 3);
        map.put('j', 1);
        map.put('k', 2);
        map.put('l', 3);
        map.put('m', 1);
        map.put('n', 2);
        map.put('o', 3);
        map.put('p', 1);
        map.put('q', 2);
        map.put('r', 3);
        map.put('s', 4);
        map.put('t', 1);
        map.put('u', 2);
        map.put('v', 3);
        map.put('w', 1);
        map.put('x', 2);
        map.put('y', 3);
        map.put('z', 4);
        map.put(' ', 1);
    }
}
