import java.util.*;
import java.io.*;

class Main {

    private static ArrayList<Word> words = new ArrayList<Word>();
    private static ArrayList<String> wordsToPrint = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while (!(in = input.readLine()).trim().equals("#")) {
            StringTokenizer st = new StringTokenizer(in);
            while (st.hasMoreTokens()) {
                Word word = new Word(st.nextToken());
                words.add(word);
            }
        }
        Collections.sort(words);
        setWordsToPrint();
        Collections.sort(wordsToPrint);
        for (String s: wordsToPrint)
            System.out.println(s);
        input.close();
    }

    private static void setWordsToPrint() {
        ListIterator<Word> litr = null;
        int size;
        int index = 0;
        for (Word w : words)
            wordsToPrint.add(w.getWord());

        for (Word word : words) {
            index = words.indexOf(word);
            size = word.getSize();
            litr = words.listIterator(index + 1);
            while (litr.hasNext()) {
                Word w = litr.next();
                if (w.getSize() > size)
                    break;
                if (word.getSorted().equals(w.getSorted())) {
                    wordsToPrint.remove(word.getWord());
                    wordsToPrint.remove(w.getWord());
                }
            }
        } 
    }

    static class Word implements Comparable<Word> {
        private String word;
        private String sorted;
        private int size;
        
        Word(String word) {
            this.word = word;
            char[] w = word.toUpperCase().toCharArray();
            Arrays.sort(w);
            this.sorted = new String(w).toUpperCase();
            this.size = word.length();
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
            if (this.size > another.getSize())
                return 1;
            if (this.size < another.getSize())
                return -1;
            return 0;
        }
    }
}
