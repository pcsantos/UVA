import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        boolean flag = false;
        while (!(in = input.readLine()).equals("0")) {
            if (flag)
                System.out.println();
            flag = true;
            int value = Integer.parseInt(in);
            process(value);
        }
        input.close();
    }

    private static void process(int n) {
        boolean solution = false;
        for (int fghij = 1234; fghij <= 98765 / n; fghij++) {
            int abcde = fghij * n;
            boolean flag;
            if(fghij < 10000)
                flag = allNumbers(String.valueOf(abcde) + "0" + String.valueOf(fghij));
            else if (abcde < 10000)
                flag = allNumbers("0" + String.valueOf(abcde) + String.valueOf(fghij));
            else
                flag = allNumbers(String.valueOf(abcde) + String.valueOf(fghij));

            if (flag) {
                System.out.format("%05d / %05d = %d\n", abcde, fghij, n);
                solution = true;
            }
        }
        if (!solution)
            System.out.println("There are no solutions for " + n +".");
    }

    private static boolean allNumbers(String n) {
        char[] arr = n.toCharArray();
        Arrays.sort(arr);
        if (Arrays.toString(arr).equals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"))
            return true;
        return false;
    }
}
