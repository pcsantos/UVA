import java.util.*;
import java.io.*;

class Main {

    private static int SIZE = 2002;
    private static boolean[] primes = new boolean[SIZE];

    public static void main(String[] args) throws IOException {
        sieveOfErasthostenes(); 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int numberOfLines = Integer.parseInt(input.readLine());
        for (int i = 1; i <= numberOfLines; i++) {
            in = input.readLine();
            ArrayList<Digit> digits = countingDigits(in);
            StringBuilder sb =  new StringBuilder();
            Collections.sort(digits);
            for (Digit d : digits) {
                if (primes[d.getOccur()])
                    sb.append(d.getDigit());
            }
            if (sb.length() > 0)
                System.out.println("Case " + i + ": " + sb.toString());
            else 
                System.out.println("Case " + i + ": empty");
        }

        input.close();
    }

    private static ArrayList<Digit> countingDigits(String in) {
    
        ArrayList<Digit> arrayList = new ArrayList<>();
        char[] array = in.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i]) || Character.isLetter(array[i])) {
                boolean insert = true;
                for (Digit d : arrayList) {
                    if (d.getDigit() == array[i]) {
                        d.addOccur();
                        insert = false;
                        break;
                    }
                }
                if (insert) {
                    Digit d = new Digit(array[i]);
                    arrayList.add(d);
                }
            }
        }
        return arrayList;
    }

    private static void sieveOfErasthostenes() {
        for (int i = 2; i < SIZE; i++)
            primes[i] = true;
        for (int i = 2; i < Math.sqrt(SIZE); i++) {
            if (primes[i]) {
                for (int j = i; i * j < SIZE; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }

    static class Digit implements Comparable<Digit> {
        private char digit;
        private int occur;
        Digit(char digit) {
            this.digit = digit;
            this.occur = 1;
        }

        char getDigit() {
            return this.digit;
        }

        int getOccur() {
            return this.occur;
        }

        void addOccur() {
            this.occur++;
        }

        public int compareTo(Digit another) {
            if ((int)this.digit > (int)another.getDigit())
                return 1;
            if ((int)this.digit < (int)another.getDigit())
                return -1;
            return 0;
        }
    }
}
