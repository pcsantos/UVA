import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        boolean first = true;
        while ((in = input.readLine()) != null) {
            if (!first)
                System.out.println();
            first = false;
            ArrayList<Digit> digits = countFrequency(in);
            Collections.sort(digits);
            for (Digit d : digits) {
                System.out.println(d.getDigit() + " " + d.getOccur());
            }
        }
        input.close();
    }

    private static ArrayList<Digit> countFrequency(String line) {
        ArrayList<Digit> arrayList = new ArrayList<Digit>();
        char[] array = line.toCharArray();
        boolean insert = true;
        for (int i = 0; i < array.length; i++) {
            insert = true;
            for (Digit l : arrayList) {
                if (l.getDigit() == (int) array[i]) {
                    l.addOccur();
                    insert = false;
                    break;
                }
            }
            if (insert) {
                Digit digit = new Digit((int) array[i]);
                arrayList.add(digit); 
            }
        }
        return arrayList;
    }

    static class Digit implements Comparable<Digit>{
        private int digit;
        private int occur;
        Digit(int digit) {
            this.digit = digit;
            this.occur = 1;
        }

        void addOccur() {
            this.occur++;
        }

        int getDigit() {
            return this.digit;
        }

        int getOccur() {
            return this.occur;
        }

        public int compareTo(Digit another) {
            if (this.occur > another.getOccur())
                return 1;
            if (this.occur < another.getOccur())
                return -1;
            if (this.digit > another.getDigit())
                return -1;
            if (this.digit < another.getDigit())
                return 1;
            return 0;
        }
    }
}
