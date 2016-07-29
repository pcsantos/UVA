import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while (!(in = input.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(in);
            int topNumber = Integer.parseInt(st.nextToken());
            int qtdBalls = Integer.parseInt(st.nextToken());
            in = input.readLine();
            String output = getOutput(topNumber, qtdBalls, in);
            System.out.println(output);
        }
        input.close();
    }

    private static String getOutput(int topNumber, int qtdBalls, String in) {
        boolean[] reachNumber = new boolean[topNumber + 1];
        int[] values = new int[qtdBalls];
        StringTokenizer st = new StringTokenizer(in);
        for (int i = 0; i < qtdBalls; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
    
        for (int i = 0; i < qtdBalls; i++) {
            for (int j = 0; j < qtdBalls; j++) {
                int abs = Math.abs(values[i] - values[j]);
                if (abs <= topNumber) {
                    reachNumber[abs] = true;
                }
            }
        }
        for (int i = 1; i <= topNumber; i++)
            if (!reachNumber[i])
                return "N";
        return "Y";
    }
}
