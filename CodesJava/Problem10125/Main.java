import java.util.*;
import java.io.*;

class Main {
    private static final int SIZE = 1000;
    private static int[] arr = new int[SIZE];

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int nElements;
        while (!(in = input.readLine()).equals("0")) {
            nElements = Integer.parseInt(in);
            for (int i = 0; i < nElements; i++) {
                arr[i] = Integer.parseInt(input.readLine());
            }
            Arrays.sort(arr, 0, nElements);
            System.out.println(sumsets(nElements));
        }
        input.close();
    }

    private static String sumsets(int n) {
        long globalMax;
        long currentMax;
        int a, b, c, d;
        globalMax = currentMax = Integer.MIN_VALUE;
        for (int i = 0; i < n - 3; i++) {
            a = arr[i];
            for (int j = i + 1; j < n; j++) {
                b = arr[j];
                for (int k = j + 1; k < n; k++) {
                    c = arr[k];
                    for (int m = 0; m < n; m++) {
                        d = arr[m];
                        currentMax = a + b + c;
                        if (d == currentMax) {
                            if (currentMax > globalMax)
                                globalMax = currentMax;
                        }
                    }
                }
            }
        }
        return globalMax != Integer.MIN_VALUE ? String.valueOf(globalMax) : "no solution";
    }
}
