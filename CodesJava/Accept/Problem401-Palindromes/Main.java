import java.util.*;
import java.io.*;

class Main {
    private static final String NOT_PALINDROME = " -- is not a palindrome.";
    private static final String REGULAR_PALINDROME = " -- is a regular palindrome.";
    private static final String MIRRORED_STRING = " -- is a mirrored string.";
    private static final String MIRRORED_PALINDROME = " -- is a mirrored palindrome.";

    private static Map<Character, Character> charAndReverse = new HashMap<Character, Character>();

    public static void main(String[] args) throws IOException {
        
        fillHashMap();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String word;
        while ((word = input.readLine()) != null) {
            String answer = getOutput(word);
            System.out.println(answer);
            System.out.println();
        }
        input.close();
    }

    private static String getOutput(String word) {
        
        String reverse = new StringBuffer(word).reverse().toString();
        if (word.equals(reverse))
            if (isMirroredString(word))
                return word + MIRRORED_PALINDROME;
            else
                return word + REGULAR_PALINDROME;
        if (isMirroredString(word)) {
            return word + MIRRORED_STRING;
        } else {
            return word + NOT_PALINDROME;
        }
    }

    private static boolean isMirroredString(String word) {

        String reverse = new StringBuffer(word).reverse().toString();
        for (int i = 0 ; i < word.length(); i++) {

            String charReverse = charAndReverse.get(word.charAt(i));
            String charToCompare = reverse.charAt(i);
            if (charReverse == null)
                return false;
            if (!charReverse.equals(charToCompare))
                return false;
        }
        return true;
    }

    private static void fillHashMap() {
        charAndReverse.put('A', 'A');
        charAndReverse.put('E', '3');
        charAndReverse.put('H', 'H');
        charAndReverse.put('I', 'I');
        charAndReverse.put('J', 'L');
        charAndReverse.put('L', 'J');
        charAndReverse.put('M', 'M');
        charAndReverse.put('S', '2');
        charAndReverse.put('T', 'T');
        charAndReverse.put('O', 'O');
        charAndReverse.put('U', 'U');
        charAndReverse.put('V', 'V');
        charAndReverse.put('W', 'W');
        charAndReverse.put('X', 'X');
        charAndReverse.put('Y', 'Y');
        charAndReverse.put('Z', '5');
        charAndReverse.put('1', '1');
        charAndReverse.put('2', 'S');
        charAndReverse.put('3', 'E');
        charAndReverse.put('5', 'Z');
        charAndReverse.put('8', '8');
    }
}
