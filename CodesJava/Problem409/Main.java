import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int set = 1;
        while ((in = input.readLine()) != null) {
            if (set > 1)
                System.out.println();
            StringTokenizer st = new StringTokenizer(in);
            int words = Integer.parseInt(st.nextToken());
            int excuses = Integer.parseInt(st.nextToken());
            ArrayList<String> wordsArr = new ArrayList<>();
            for (int i = 0; i < words; i++) {
                wordsArr.add(input.readLine().toLowerCase());
            }
            ArrayList<Excuse> exArr = new ArrayList<>();
            for (int i = 0; i < excuses; i++) {
                Excuse ex = new Excuse(input.readLine(), wordsArr);
                exArr.add(ex);
            }
            Collections.sort(exArr);
            Collections.reverse(exArr);
            int w = exArr.get(0).getWeight();
            System.out.println("Excuse Set #" + set++);
            for (Excuse e : exArr) {
                if (w == e.getWeight())
                    System.out.println(e.getExcuse());
                else
                    break;
            }
        }
        input.close();
    }

    private static class Excuse implements Comparable<Excuse>{
        private String excuse;
        private int weight;

        Excuse (String excuse, ArrayList<String> words) {
            this.excuse = excuse;
            this.weight = setWeight(excuse.toLowerCase(), words);
        }

        private int setWeight(String excuse, ArrayList<String> words) {
            excuse = excuse.replace("\"", " ");
            excuse = excuse.replace(".", " ");
            excuse = excuse.replace(",", " ");
            excuse = excuse.replace("!", " ");
            excuse = excuse.replace("?", " ");
            for (int i = 0; i < 10; i++) {
                excuse = excuse.replace(String.valueOf(i), " ");
            }
            StringTokenizer st = new StringTokenizer(excuse);
            int count = 0;
            while (st.hasMoreTokens()) {
                String w = st.nextToken();
                for (String s : words) {
                    if (w.equals(s)) {
                        count++;
                        break;
                    }
                }
            }           
            return count;
        }

        private String getExcuse() {
            return this.excuse;
        }

        private int getWeight() {
            return this.weight;
        }
        
        public int compareTo(Excuse another) {
            if (this.weight < another.getWeight())
                return -1;
            if (this.weight > another.getWeight())
                return 1;
            return 0;
        }
    }
}
