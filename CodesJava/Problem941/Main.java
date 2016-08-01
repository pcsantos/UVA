import java.util.*;
import java.io.*;

class Main {


    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            String str = input.readLine();
            permutation(str);
            int index = Integer.parseInt(input.readLine());
        }
        input.close();
    }

    private static void permutation(String str) {
    
        char[] temp  = str.toCharArray();

        Arrays.sort(temp);
        System.out.println("String " + String.valueOf(temp));

        int index = 0;
        int lowest = 0;
        while (true) {
            
            for (int i = 0; i < temp.length - 1; i++) {
                if (temp[i] < temp[i+1]) {
                    lowest = i;
                }
            }

            index = lowest;

            int j = findCeiling(temp, index);

            if (j == index) break;

            swap(temp, index, j);
            String a = String.valueOf(temp);

            char[] b = a.substring(index + 1).toCharArray();
            Arrays.sort(b);
            a = a.substring(0, index + 1) + String.valueOf(b);
            temp = a.toCharArray();
            System.out.println("String " + String.valueOf(temp));
        }
    }

    private static int findCeiling(char[] temp, int index) {
        int k = index;
        char test = temp[index];
        while (k < temp.length - 1) {
            if (temp[index] < temp[k + 1]) {
                index = k + 1;
                break;
            }
            k++;
        }
        k = index;
        while (k < temp.length - 1) {
            if ((temp[index] > temp[k + 1]) && (temp[k + 1] > test)) {
                index = k + 1;
            }
            k++;
        }
        return index;
    }

    private static void swap(char[] str, int i, int j) {
    
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
