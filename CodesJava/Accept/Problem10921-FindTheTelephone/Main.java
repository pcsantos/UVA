import java.util.*;
import java.io.*;

class Main {
    private static HashMap<Character, Character> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        fillMap();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            System.out.println(correspondingNumber(in));
        }
        input.close();
    }

    private static String correspondingNumber(String in) {
        char[] array = in.toCharArray();
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            newString.append(map.get(array[i]));
        }
        return newString.toString();
    }

    private static void fillMap() {
        map.put('0', '0');
        map.put('1', '1');
        map.put('-', '-');
        map.put('A', '2');
        map.put('B', '2');
        map.put('C', '2');
        map.put('D', '3');
        map.put('E', '3');
        map.put('F', '3');
        map.put('G', '4');
        map.put('H', '4');
        map.put('I', '4');
        map.put('J', '5');
        map.put('K', '5');
        map.put('L', '5');
        map.put('M', '6');
        map.put('N', '6');
        map.put('O', '6');
        map.put('P', '7');
        map.put('Q', '7');
        map.put('R', '7');
        map.put('S', '7');
        map.put('T', '8');
        map.put('U', '8');
        map.put('V', '8');
        map.put('W', '9');
        map.put('X', '9');
        map.put('Y', '9');
        map.put('Z', '9');
    }
}
