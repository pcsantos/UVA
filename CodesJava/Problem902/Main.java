import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            System.out.println(getPassword(in));
        }
        input.close();
    }

    private static String getPassword(String in) {
        ArrayList<Password> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(in);
        int size = Integer.parseInt(st.nextToken());
        String text = st.nextToken();
        for (int i = 0; i <= text.length() - size; i++) {
            String pass = text.substring(i, size + i);
            boolean insert = true;
            for (Password p : list) {
                if (p.getPass().equals(pass)) {
                    insert = false;
                    p.addOccur();
                    break;
                }
            }
            if (insert) {
                Password p =  new Password(pass);
                list.add(p);
            }
        }
        Collections.sort(list);
        return Collections.max(list).getPass();
    }

    static class Password implements Comparable<Password> {
        private String pass;
        private int occur;
        Password(String pass) {
            this.pass = pass;
            this.occur = 1;
        }

        String getPass() {
            return this.pass;
        }

        int getOccur() {
            return this.occur;
        }

        void addOccur() {
            this.occur++;
        }

        public int compareTo(Password another) {
            if (this.occur > another.getOccur())
                return 1;
            if (this.occur < another.getOccur())
                return -1;
            return 0;
        }
    }
}
