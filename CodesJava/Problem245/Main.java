import java.util.*;
import java.io.*;

class Main {

    private static LinkedList<String> list = new LinkedList<>();
    private static ArrayList<Pair> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while (!(in = input.readLine()).trim().equals("0")) {
            System.out.println(changeOutput(in));
        }
        input.close();
    }
    
    private static String changeOutput(String in) {
        String aux = in;
        StringTokenizer st = new StringTokenizer(aux);
        while (st.hasMoreTokens()) {
            in = addWord(st.nextToken(), in);
        }
        return in;
    }
    
    private static String addWord(String word, String in) {
        StringTokenizer st = new StringTokenizer(word, "-'.,");
        String w;
        while (st.hasMoreTokens()) {
            w = st.nextToken();
            if (w.matches("\\d+")) {
                int index = Integer.parseInt(w) - 1;
                String change = list.get(index);
                Pair pair = new Pair(w, change);
                arr.add(pair);
                in = in.replaceFirst(w, change);
                change = list.remove(index);
                list.addFirst(change);
            } else
                list.addFirst(w);
        }
        return in;
    }

    static class Pair {
        private String index;
        private String value;
        
        Pair(String index, String value) {
            this.index = index;
            this.value = value;
        }

        String getIndex() {
            return this.index;
        }

        String getValue() {
            return this.value;
        }
    }
}
