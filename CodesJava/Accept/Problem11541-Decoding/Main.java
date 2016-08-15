import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());     
        for (int i = 1; i <= testCases; i++) {
            in = input.readLine();
            System.out.println("Case " + i + ": " + getSequence(in));
        }
        input.close();
    }

    private static String getSequence(String in) {
        char[] array = in.toCharArray();
        StringBuilder out = new StringBuilder();
        char aux;
        for (int i = 0; i < array.length; i++) {
            aux = array[i];
            StringBuilder value = new StringBuilder();
            for (int j = i + 1; j < array.length; j++) {
                if (Character.isDigit(array[j])) {
                    value.append(array[j]);
                } else {
                    out.append(getPartialOut(aux, value.toString()));
                    i = j - 1;
                    break;
                }
                if (j == array.length - 1) {
                    out.append(getPartialOut(aux, value.toString()));
                    i = j;
                }
            }
        } 
        return out.toString();
    }

    private static String getPartialOut(char value, String in) {
        int max = Integer.parseInt(in);
        StringBuilder partialOut = new  StringBuilder();
        for (int i = 0; i < max; i++) {
            partialOut.append(value);
        }
        return partialOut.toString();
    }
}
