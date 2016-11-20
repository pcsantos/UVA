import java.util.*;
import java.io.*;

class Main {

    private static final int ROUND = 13;

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while ((in = input.readLine()) != null) {
            for (int i = 0; i < ROUND; i++) {
                System.out.println(in);
            }
        }
        input.close();
    }

    static class Hand {
        private int[] rounds;
        private int bonus;
        Hand() {
            this.rounds = new int[ROUND];
            this.bonus = 0;
        }
    }
}
