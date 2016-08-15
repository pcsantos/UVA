import java.util.*;
import java.io.*;

class Main {

    private static ArrayList<Letter> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String line;
        int linesNumber = Integer.parseInt(input.readLine());
        for (int i = 0; i < linesNumber; i++) {
            line = input.readLine();
            countFrequency(line.toUpperCase());
        }
        Collections.sort(arrayList);
        for (Letter l : arrayList) {
            System.out.println(l.getLetter() + " " + l.getOccur());
        }
        input.close();
    }

    private static void countFrequency(String line) {
        char[] array = line.toCharArray();
        boolean insert = true;
        for (int i = 0; i < array.length; i++) {
            insert = true;
            if (Character.isLetter(array[i])) {
                for (Letter l : arrayList) {
                    if (l.getLetter() == array[i]) {
                        l.addOccur();
                        insert = false;
                        break;
                    }
                }
                if (insert) {
                    Letter letter = new Letter(array[i]);
                    arrayList.add(letter); 
                }
            }
        }
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
