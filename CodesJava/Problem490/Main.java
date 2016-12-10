import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        ArrayList<String> arr = new ArrayList<>();
        int wordsNumber = 0;
        while ((in = input.readLine()) != null) {
            arr.add(in);
            wordsNumber++;
        }
        Collections.reverse(arr);
        int maxSize = 0;
        char[][] word = new char[100][wordsNumber];    
        for (int i = 0; i < wordsNumber; i++) {
            String w = arr.get(i);
            for(int j = 0; j < w.length(); j++) {
                word[j][i] = w.charAt(j);
                if (j > maxSize)
                    maxSize = j;
            }
        }
        for (int i = 0; i < maxSize; i++)
            System.out.println(word[i]);

        input.close();
    }
}
