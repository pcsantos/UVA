import java.util.*;
import java.io.*;

class Main {

    private static final int MAX = 21;
    private static long[] fact = new long[MAX];

    public static void main(String[] args) throws IOException {
   
        calcFactorial();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());     
        for (int i = 1; i <= testCases; i++) {
            in = input.readLine();
            System.out.println("Data set " + i + ": " + calcRearrange(in));
        }
        input.close();
    }

    private static long calcRearrange(String in) {
        ArrayList<Letter> arrayList = new ArrayList<>();
        char[] array = in.toCharArray();
        boolean insert = true;
        Letter letter = new Letter(array[0], 1);
        arrayList.add(letter);
        for (int i = 1; i < array.length; i++) {
            letter = new Letter(array[i], 1);
            insert = true;    
            for (Letter l : arrayList) {
                if (l.getLetter() == array[i]) {
                    l.addOccur();
                    insert = false;
                    break;
                }
            }
            if (insert) arrayList.add(letter);
        }
        long times = fact[array.length];
        long divisor = 1;
        for (Letter l : arrayList) {
            divisor *= fact[l.getOccur()];
        }
        return times/divisor;
    }

    private static void calcFactorial() {
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = fact[i-1] * i;
        }
    }

    static class Letter {
        private char letter;
        private int occur;

        Letter(char letter, int occur) {
            this.letter = letter;
            this.occur = occur;
        }

        char getLetter() {
            return this.letter;
        }

        int getOccur() {
            return this.occur;
        }

        void addOccur() {
            this.occur++;
        }
    }
}
