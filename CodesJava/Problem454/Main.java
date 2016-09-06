import java.util.*;
import java.io.*;

class Main {

    private static ArrayList<Word> words = new ArrayList<Word>();
    private static ArrayList<Pair> pairsToPrint = new ArrayList<Pair>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());
        input.readLine();
        for (int i = 0; i < testCases; i++) {
            if (i > 0)
                System.out.println();
            in = input.readLine();
            while (in != null && !in.trim().equals("")) {
                Word word = new Word(in);
                words.add(word);
                in = input.readLine();
            }
            Collections.sort(words);
            setPairsToPrint();
            Collections.sort(pairsToPrint);
            if (pairsToPrint.size() == 0) {
                System.out.println();
            } else {
                for (Pair pair : pairsToPrint) {
                    if (pair.getWord().compareTo(pair.getPair()) <= 0)
                        System.out.println(pair.getWord() + " = " + pair.getPair());
                    else
                        System.out.println(pair.getPair() + " = " + pair.getWord());
                }
            }
            words.clear();
            pairsToPrint.clear();
        }
        input.close();
    }

    private static void setPairsToPrint() {
        ListIterator<Word> litr = null;
        int size;
        int index = 0;

        for (Word word : words) {
            index = words.indexOf(word);
            size = word.getSize();
            litr = words.listIterator(index + 1);
            while (litr.hasNext()) {
                Word w = litr.next();
                if (word.getSorted().equals(w.getSorted())) {
                    Pair pair = new Pair(word.getWord(), w.getWord());
                    pairsToPrint.add(pair);
                }
            }
        } 
    }
    
    static class Pair implements Comparable<Pair> {
        private String word;
        private String pair;
        Pair(String word, String pair) {
            this.word = word;
            this.pair = pair;
        }

        String getWord() {
            return this.word;
        }
        String getPair() {
            return this.pair;
        }

        public int compareTo(Pair another) {
            return this.word.compareTo(another.getWord());
        }
    }


    static class Word implements Comparable<Word> {
        private String word;
        private String sorted;
        private int size;
        
        Word(String word) {
            this.word = word;
            char[] w = word.toUpperCase().trim().replace(" ", "").toCharArray();
            Arrays.sort(w);
            this.sorted = new String(w).toUpperCase();
            this.size = sorted.length();
        }
        
        int getSize() {
            return this.size;
        }

        String getSorted() {
            return this.sorted;
        }

        String getWord() {
            return this.word;
        }

        public int compareTo(Word another) {
            return this.word.compareTo(another.getWord());
        }
    }
}
