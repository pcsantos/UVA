import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String word;
        while ((word = input.readLine()) != null) {
            int numberOfPalindromes = getNumberOfPalindromes(word);
            System.out.println("The string '" + word + "' contains " + numberOfPalindromes + " palindromes.");
        }
    }

    private static int getNumberOfPalindromes(String word) {
        Set<String> palindromes = new HashSet<String>();
        for (int i = 0; i < word.length(); i++) {
            palindromes.add(word.charAt(i)+"");
        }
        
        for (int j = 2; j < word.length() + 1; j++) {
            int k = j;
            for (int i = 0; i < word.length() + 1 - j; i++) {
                String sub = word.substring(i,k++);
                if (isPalindrome(sub))
                    palindromes.add(sub);
            }
        }
        return palindromes.size();
    }

    private static boolean isPalindrome(String word) {
    
        String reverse = new StringBuilder(word).reverse().toString();
        if (word.equals(reverse))
            return true;
        return false;
    }
}
