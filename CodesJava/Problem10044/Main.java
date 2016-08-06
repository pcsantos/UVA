import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
        String in;
        while((in = input.readLine()).equals(""));
        int testCases = Integer.parseInt(in);
        for (int i = 0; i < testCases; i++) {
            while((in = input.readLine()).equals(""));
            StringTokenizer st = new StringTokenizer(in);
            int papers = Integer.parseInt(st.nextToken());
            int authors = Integer.parseInt(st.nextToken());
            ArrayList<CoAuthor> list = new ArrayList<CoAuthor>();
            for (int j = 0; j < papers; j++) {
                while((in = input.readLine()).equals(""));
                st = new StringTokenizer(in, ":");
                StringBuilder sb = new StringBuilder(st.nextToken());
                sb.append(",");
                CoAuthor coAuthor =  new CoAuthor(sb.toString());
                list.add(coAuthor);
            }
            String[] authorsList = new String[authors];
            for (int j = 0; j < authors; j++) {
                while((in = input.readLine()).equals(""));
                authorsList[j] = in;
            }
            System.out.println("Scenario " + (i + 1));
            HashSet<Author> ranked = classifyAuthors(list);
            for (int j = 0; j < authors; j++) {
                boolean thereIsNot = true;
                Iterator it =  ranked.iterator();
                while (it.hasNext()) {
                    Author a = (Author)it.next();
                    if (authorsList[j].equals(a.getName())) {
                        System.out.println(a.getName() + " " + a.getErdosNumber());
                        thereIsNot =  false;
                        break;
                    }
                }
                if (thereIsNot)
                    System.out.println(authorsList[j] + " infinity");
            }
        }
        input.close();
    }

    private static HashSet<Author> classifyAuthors(ArrayList<CoAuthor> list) {
        String erdos = "Erdos, P.";
        Author author = new Author(erdos, 1);
        LinkedList<Author> authors =  new LinkedList<Author>();
        authors.add(author);
        ArrayList<String> names;
        HashSet<Author> ranked = new HashSet<>();
        int erdosNumber = 1;
        while (authors.size() > 0) {
            author = authors.removeLast();
            ranked.add(author);
            ArrayList<CoAuthor> toRemove = new ArrayList<>();
            for (CoAuthor coAuthor : list) {
                names = coAuthor.getNames();
                for (String s : names) {
                    if (s.equals(author.getName())) {
                        insertAuthors(names, authors, erdosNumber, ranked);
                        toRemove.add(coAuthor);
                        break;
                    }
                }    
            }
            for (CoAuthor coAuthor : toRemove)
                list.remove(coAuthor);
            erdosNumber++; 
        }
        return ranked;
    }

    private static void insertAuthors(ArrayList<String> names, LinkedList<Author> authors, 
                        int erdosNumber, HashSet<Author> ranked) {
        
        for (String name : names) {
            boolean insert = true;

            Iterator it = ranked.iterator();
            while (it.hasNext()) {
                Author a = (Author) it.next();
                if (a.getName().equals(name)) {
                    insert = false;
                    break;
                }
            }
            if (insert) {
                Author author = new Author(name, erdosNumber);
                authors.addFirst(author);
            }
        }
    }

    static class Author {
        private String name;
        private int erdosNumber;

        Author(String name, int erdosNumber) {
            this.name = name;
            this.erdosNumber = erdosNumber;
        }

        String getName() {
            return this.name;
        }
        
        int getErdosNumber() {
            return this.erdosNumber;
        }
    }

    static class CoAuthor {
        
        private ArrayList<String> names = new ArrayList<>();

        CoAuthor(String names) {
            StringTokenizer st =  new StringTokenizer(names, ",");
            while (st.hasMoreTokens()) {
                String name = st.nextToken().trim() + ", " + st.nextToken().trim();
                this.names.add(name);
            }
        }
        ArrayList<String> getNames() {
            return names;
        }
    }
}
