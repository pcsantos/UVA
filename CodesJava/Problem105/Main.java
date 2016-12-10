import java.util.*;
import java.io.*;

class Main {

    private static int[] arr = new int[10002];
    private static int maxRight = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            insertBuild(in);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=maxRight; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
        for (int i = 1; i <= maxRight + 1; i++)
            if (arr[i] != arr[i - 1]) {
                if (arr[i] > arr[i - 1])
                    sb.append(i + " " + arr[i] + " ");
                else
                    sb.append((i - 1) + " " + arr[i] + " ");

            }
        System.out.println(sb.toString().trim());
        input.close();
    }

    private static void insertBuild(String in) {
        StringTokenizer st = new StringTokenizer(in);
        int left = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        int right = Integer.parseInt(st.nextToken());
        for (int i = left; i <= right; i++) {
            if (arr[i] < weight)
                arr[i] = weight;
            if (maxRight < right)
                maxRight = right;
        }
    }
}
