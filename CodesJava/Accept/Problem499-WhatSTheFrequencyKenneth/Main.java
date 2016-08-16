import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String line;
        while ((line = input.readLine()) != null) {
            ArrayList<Letter> arrayList = contingLetters(line);
            int occur = Collections.min(arrayList).getOccur();
            for (Letter l : arrayList) {
                if (l.getOccur() == occur)
                    System.out.print(l.getLetter());
                else
                    break;
            }
            System.out.println(" " + occur);
        }
        input.close();
    }

    private static ArrayList<Letter> contingLetters(String line) {
        ArrayList<Letter> arrayList = new ArrayList<>();
        char[] array = line.toCharArray();
        boolean insert = true;
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])) {
                insert = true;
                for (Letter l : arrayList) {
                    if (l.getLetter() == array[i]) {
                        l.addOccur();
                        break;
                    }
                }
                if (insert) {
                    Letter letter = new Letter(array[i]);
                    arrayList.add(letter);
                }
            }
        }
        Collections.sort(arrayList);
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
