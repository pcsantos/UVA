import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));   
        String in;
        while ((in = input.readLine()) != null) {
            System.out.println(countWords(in));
        }
        input.close();
    }

    private static int countWords(String in) {
        int count = 0;
        char[] array = in.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])) {
                count++;
                for (int j = i + 1; j < array.length; j++) {
                    if (!Character.isLetter(array[j])) {
                        i = j;
                        break;
                    }
                    if (j == array.length - 1)
                        i = j;
                }
            }
        }
        return count;
    }
}
