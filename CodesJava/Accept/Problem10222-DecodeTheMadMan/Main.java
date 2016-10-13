import java.util.*;
import java.io.*;

class Main {

    private static Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        startMap();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            char[] arr = in.toCharArray();
            for (int i = 0; i < arr.length; i++)
                System.out.print(map.get(Character.toLowerCase(arr[i])));
            System.out.println();
        }
        input.close();
    }

    private static void startMap() {
        map.put('d', 'a');
        map.put('m', 'b');
        map.put('b', 'c');
        map.put('g', 'd');
        map.put('t', 'e');
        map.put('h', 'f');
        map.put('j', 'g');
        map.put('k', 'h');
        map.put('p', 'i');
        map.put('l', 'j');
        map.put(';', 'k');
        map.put('\'', 'l');
        map.put('.', 'm');
        map.put(',', 'n');
        map.put('[', 'o');
        map.put(']', 'p');
        map.put('e', 'q');
        map.put('y', 'r');
        map.put('f', 's');
        map.put('u', 't');
        map.put('o', 'u');
        map.put('n', 'v');
        map.put('r', 'w');
        map.put('v', 'x');
        map.put('i', 'y');
        map.put('c', 'z');
        map.put('=', '0');
        map.put('3', '1');
        map.put('4', '2');
        map.put('5', '3');
        map.put('6', '4');
        map.put('7', '5');
        map.put('8', '6');
        map.put('9', '7');
        map.put('0', '8');
        map.put('-', '9');
        map.put(' ', ' ');
    }
}
