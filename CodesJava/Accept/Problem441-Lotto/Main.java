import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        boolean flag = false;
        while (!(in = input.readLine()).trim().equals("0")) {
            if (flag)
                System.out.println();
            flag = true;
            process(in);        
        }
        input.close();
    }

    private static void process(String in) {
        StringTokenizer st = new StringTokenizer(in);
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int a = 0; a < k - 5; a++)
            for (int b = a + 1; b < k - 4; b++)
                for (int c = b + 1;  c < k - 3; c++)
                    for (int d = c + 1; d < k - 2; d++)
                        for (int e = d + 1; e < k - 1; e++)
                            for (int f = e + 1; f < k; f++)
                                System.out.format("%d %d %d %d %d %d\n", arr[a], arr[b], arr[c], arr[d], arr[e], arr[f]);
    }
}
