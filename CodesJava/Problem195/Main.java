import java.util.*;
import java.io.*;

class Main {

    private static SortedSet<String> words = new TreeSet<String>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int numberTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberTestCases; i++) {
                String word = input.readLine();
                combString(word);
                Iterator it = words.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
                words.clear();
        }
        input.close();
    }

    public static void combString(String s) {
        words.add(s);
        char[] a = s.toCharArray();
        int n = a.length;
        int[] p = new int[n]; 
        int i = 1;
        while (i < n) {
            if (p[i] < i) {
                int j = ((i % 2) == 0) ? 0 : p[i];
                swap(a, i, j);
                words.add(join(a));
                p[i]++;
                i = 1;
            }
            else { 
                p[i] = 0;
                i++;
            }
        }
    }

    private static String join(char[] a) {
        StringBuilder builder = new StringBuilder();
        builder.append(a);
        return builder.toString();
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

