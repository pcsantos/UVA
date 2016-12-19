import java.util.*;
import java.io.*;

class Main {

    private static final int SIZE = 5001;
    private static int[] arr = new int[SIZE];

    public static void main(String[] args) throws IOException {
        initArr();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while ( (in = input.readLine()) != null ) {
            StringTokenizer st = new StringTokenizer(in);
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            System.out.println(arr[high] - arr[low - 1]);
        }
        input.close();
    }

    private static void initArr() {
        String aux;
        boolean flag;
        for (int i = 1; i < 11; i++)
            arr[i] = arr[i - 1] + 1;

        for (int i = 11; i < SIZE; i++) {
            aux = String.valueOf(i);
            flag = false;
            char[] a = aux.toCharArray();
            for (int j = 0; j < a.length - 1; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[j] == a[k]) {
                        flag = true;
                        arr[i] = arr[i - 1];
                        break;
                    }
                }
                if (flag) break;
            }
            if (!flag) 
                arr[i] = arr[i - 1] + 1;
        }
    }
}
