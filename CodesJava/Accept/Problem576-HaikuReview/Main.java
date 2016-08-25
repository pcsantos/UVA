import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while (!(in = input.readLine()).equals("e/o/i")) {
            System.out.println(verifyHaiku(in)); 
        }
        input.close();
    }

    private static char verifyHaiku(String in) {
        StringTokenizer st = new StringTokenizer(in, "/");
        int count = 1;
        String line;
        while (st.hasMoreTokens()) {
            line = st.nextToken();
            if (count % 2 != 0) {
                if (!isCorrect(line, 5))
                    if (count == 1)
                        return '1';
                    else
                        return '3';
            } else {
                if (!isCorrect(line, 7))
                    return '2';
            }
            count++;
        }
        return 'Y';
    }

    private static boolean isCorrect(String in, int syNumber) {
        char[] array = in.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(isVowel(array[i])) {
                count++;
                for (int j = i + 1; j < array.length; j++) {
                    if (!isVowel(array[j])) {
                        i = j;
                        break;
                    }
                    if (j == array.length - 1)
                        i = j;
                }
            } 
        }
        if (count == syNumber)
            return true; 
        return false;
    }

    private static boolean isVowel(char letter) {
        switch (letter) {
            case 'a' :
            case 'e' :
            case 'i' :
            case 'o' :
            case 'u' :
            case 'y' : return true;
            default : return false;
        }       
    }
}
