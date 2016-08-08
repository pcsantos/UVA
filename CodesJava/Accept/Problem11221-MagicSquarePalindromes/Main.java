import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = input.readLine();
        int numberOfTestCases = Integer.parseInt(line);
        for (int i = 1; i <= numberOfTestCases; i++) {
            line = input.readLine();
            String output = getOutput(line);
            System.out.println("Case #" + i + ":");
            System.out.println(output);
        }
        input.close();
    }

    private static String getOutput(String line) {
        
        String formattedLine = formatLine(line);
        if (isPerfectSquare(formattedLine.length())) {
            if (isMagicSquarePalindrome(formattedLine))
                return "" + (int)Math.sqrt(formattedLine.length());
        }

        return "No magic :(";
    }

    private static boolean isMagicSquarePalindrome(String line) {
        int size = (int)Math.sqrt(line.length());
        char[][] table = new char[size][size];
        String[] words = new String[size];
        
        for (int i = 0; i < size; i++) {
            words[i] = "";
        }

        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = line.charAt(k);
                words[i] += line.charAt(k);
                k++;
            }
        }
        
        if (startCellOneOneToDown(table, words, size))
            if (startCellKKToLeft(table, words, size))
                if (startCellKKToUp(table, words, size))
                    return true;

        return false;
    }

    private static boolean startCellOneOneToDown(char[][] table, String[] words, int size) {
   
        String aux = "";
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                aux += table[i][j];
            }
            if (!words[j].equals(aux))
                return false;
            aux = "";
        }
        return true;
    }

    private static boolean startCellKKToLeft(char[][] table, String[] words, int size) {
        
        String aux = "";
        int k = 0;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                aux += table[i][j];
            }
            if (!words[k].equals(aux))
                return false;
            aux = "";
            k++;
        }
        return true;
    }
    private static boolean startCellKKToUp(char[][] table, String[] words, int size) {
        
        String aux = "";
        int k = 0;
        for (int j = size - 1; j >= 0; j--) {
            for (int i = size - 1; i >= 0; i--) {
                aux += table[i][j];
            }
            if (!words[k].equals(aux))
                return false;
            aux = "";
            k++;
        }
        return true;
    }

    private static boolean isPerfectSquare(int number) {
    
        int sqrt = (int)Math.sqrt(number);
        if ((sqrt * sqrt) == number)
            return true;
        return false;
    }

    private static String formatLine(String line) {
        
        String newLine = line.replace(" ", "");
        newLine = newLine.replace(",", "");
        newLine = newLine.replace(".", "");
        newLine = newLine.replace("?", "");
        newLine = newLine.replace("!", "");
        newLine = newLine.replace("(", "");
        newLine = newLine.replace(")", "");
        return newLine;
    }
}
