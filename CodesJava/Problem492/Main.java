import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
        String in;
        while ((in = input.readLine()) != null) {
            output.write(getOutput(in)+"\n");
            output.flush();
        }
        output.close();
        input.close();
    }

    private static String getOutput(String in) {
        StringTokenizer st = new StringTokenizer(in);
        StringBuilder out = new StringBuilder();
        char[] array = in.toCharArray();
        for (int i = 0 ; i < array.length; i++) {
            if (Character.isLetter(array[i])) {
                StringBuilder word = new StringBuilder();
                word.append(array[i]);
                for (int j = i + 1; j < array.length; j++) {
                    if(Character.isLetter(array[j])) {
                        word.append(array[j]);
                    } else {
                        i = j - 1;
                        break;
                    }
                    if (j == array.length - 1)
                        i = j;
                }
                out.append(changeWord(word.toString()));
            } else {
                out.append(array[i]);
            }
        }
        return out.toString();
    }

    private static String changeWord(String word) {
        if (isVowel(word.charAt(0))) {
            return word + "ay";
        } else {
            return word.substring(1) + word.charAt(0) + "ay";
        }
    }

    private static boolean isVowel(char c) {
        String vowels = "aeiouAEIOU";
        return vowels.contains(String.valueOf(c));
    }
}
