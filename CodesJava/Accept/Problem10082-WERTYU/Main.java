import java.util.*;
import java.io.*;

class Main {

    private static HashMap<String, String> keyboard = new HashMap<String, String>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        mapKeys();
        while ((in = input.readLine()) != null) {
            for (int i = 0; i < in.length(); i++) {
                String key = in.charAt(i) + "";
                System.out.print(keyboard.get(key));    
            }
            System.out.println();
        } 
        input.close();
    }

    private static void mapKeys() {
        keyboard.put("=", "-");
        keyboard.put("-", "0");
        keyboard.put("0", "9");
        keyboard.put("9", "8");
        keyboard.put("8", "7");
        keyboard.put("7", "6");
        keyboard.put("6", "5");
        keyboard.put("5", "4");
        keyboard.put("4", "3");
        keyboard.put("3", "2");
        keyboard.put("2", "1");
        keyboard.put("1", "`");
        keyboard.put("\\", "]");
        keyboard.put("]", "[");
        keyboard.put("[", "P");
        keyboard.put("P", "O");
        keyboard.put("O", "I");
        keyboard.put("I", "U");
        keyboard.put("U", "Y");
        keyboard.put("Y", "T");
        keyboard.put("T", "R");
        keyboard.put("R", "E");
        keyboard.put("E", "W");
        keyboard.put("W", "Q");
        keyboard.put("'", ";");
        keyboard.put(";", "L");
        keyboard.put("L", "K");
        keyboard.put("K", "J");
        keyboard.put("J", "H");
        keyboard.put("H", "G");
        keyboard.put("G", "F");
        keyboard.put("F", "D");
        keyboard.put("D", "S");
        keyboard.put("S", "A");
        keyboard.put("/", ".");
        keyboard.put(".", ",");
        keyboard.put(",", "M");
        keyboard.put("M", "N");
        keyboard.put("N", "B");
        keyboard.put("B", "V");
        keyboard.put("V", "C");
        keyboard.put("C", "X");
        keyboard.put("X", "Z");
        keyboard.put(" ", " ");
    }
}
