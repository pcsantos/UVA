import java.util.*;
import java.io.*;

class Main {
    private static final int SIZE = 31;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while (true) {
            StringBuilder sb = new StringBuilder();
            in = input.readLine();
            while (in != null) {
                if (!in.trim().equals("")) {
                    if (!in.trim().equals("#")) {
                        if (Character.isLetter(in.charAt(in.length()-1)))
                            sb.append(in + " ");
                        else
                            sb.append(in);
                    } else
                        break;
                }
                in = input.readLine();
            }

            if (in == null)
                break;
            int[] wordSizes = countingWords(sb.toString());
            for (int i = 1; i < SIZE; i++) {
                if (wordSizes[i] > 0)
                    System.out.println(i + " " + wordSizes[i]);
            }
            System.out.println();
        }
        input.close();
    }

    private static int[] countingWords(String in) {
        int[] times = new int[SIZE];
        StringTokenizer st = new StringTokenizer(in, " ?!,.");
        while (st.hasMoreTokens()) {
            String strClear = st.nextToken().replace("-", "");
            strClear = strClear.replace("’", "");
            strClear = strClear.replace("'", "");
            times[strClear.length()]++;
        }
        return times;
    }
}
