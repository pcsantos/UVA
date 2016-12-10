import java.util.*;
import java.io.*;

class Main {

    private static final int SIZE = 26;
    private static int[] arr = new int[SIZE];
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        ArrayList<String> arrList = new ArrayList<>();
        String in;
        while (!(in = input.readLine()).trim().equals("#"))
            arrList.add(in);
        
        while (!(in = input.readLine()).trim().equals("#")) {
            initArr(in);
            System.out.println(diffWords(arrList));
            clearArr();
        }

        input.close();
    }

    private static int diffWords(ArrayList<String> arrList) {
        int count = 0;
        boolean flag;
        for (String s : arrList) {
            char[] word = s.toCharArray();
            int[] aux = new int[SIZE];
            for (int i = 0; i < word.length; i++) {
                int index = alpha.indexOf(word[i]);
                aux[index]++;
            }
            flag = true;
            for (int i = 0; i < SIZE; i++) {
                if (aux[i] > arr[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        return count;
    }

    private static void initArr(String in) {
        StringTokenizer st = new StringTokenizer(in);
        while (st.hasMoreTokens()) {
            int index = alpha.indexOf(st.nextToken().charAt(0));
            arr[index]++;
        }
    }

    private static void clearArr() {
        for (int i = 0; i < SIZE; i++)
            arr[i] = 0;
    }
}
