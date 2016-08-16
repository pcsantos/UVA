import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());
        String in;
        for (int i = 0; i < testCases; i++) {
            in = input.readLine();
            ArrayList<Letter> letters = countFrequency(in);
            Collections.sort(letters);
            int occur = Collections.min(letters).getOccur();
            StringBuilder sb = new StringBuilder();
            for (Letter l : letters) {
                if (l.getOccur() == occur)
                    sb.append(Character.toLowerCase(l.getLetter()));
            }
                System.out.println(sb.toString());
        }
        input.close();
    }

    private static ArrayList<Letter> countFrequency(String line) {
        ArrayList<Letter> arrayList = new ArrayList<Letter>();
        char[] array = line.toCharArray();
        boolean insert = true;
        for (int i = 0; i < array.length; i++) {
            insert = true;
            if (Character.isLetter(array[i])) {
                for (Letter l : arrayList) {
                    if (l.getLetter() == Character.toUpperCase(array[i])) {
                        l.addOccur();
                        insert = false;
                        break;
                    }
                }
                if (insert) {
                    Letter letter = new Letter(Character.toUpperCase(array[i]));
                    arrayList.add(letter); 
                }
            }
        }
        return arrayList;
    }

    static class Letter implements Comparable<Letter>{
        private char letter;
        private int occur;
        Letter(char letter) {
            this.letter = letter;
            this.occur = 1;
        }

        void addOccur() {
            this.occur++;
        }

        char getLetter() {
            return this.letter;
        }

        int getOccur() {
            return this.occur;
        }

        public int compareTo(Letter another) {
            if (this.occur > another.getOccur()) 
                return -1;
            if (this.occur < another.getOccur())
                return 1;
            if (this.letter < another.getLetter())
                return -1;
            if (this.letter > another.getLetter())
                return 1;
            return 0;
        }
    }
}
