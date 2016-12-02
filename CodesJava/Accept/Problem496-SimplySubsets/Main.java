import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ( (in = input.readLine()) != null) {
            HashSet<String> setA = getSet(in);
            in = input.readLine();
            HashSet<String> setB = getSet(in);
            System.out.println(getResult(setA, setB));
        }
        input.close();
    }

    private static String getResult(HashSet<String> setA, HashSet<String> setB) {
        if (setA.equals(setB))
            return "A equals B";
        if (setA.size() > setB.size()) {
            if (setA.containsAll(setB))
                return "B is a proper subset of A";
        } else {
            if(setB.containsAll(setA))
                return "A is a proper subset of B";
        }
        int unionAB = setA.size() + setB.size();
        setA.addAll(setB);
        if (setA.size() == unionAB)
            return "A and B are disjoint";
        return "I'm confused!";
    }

    private static HashSet<String> getSet(String in) {
        StringTokenizer st = new StringTokenizer(in);
        HashSet<String> set = new HashSet<>();
        while (st.hasMoreTokens())
            set.add(st.nextToken());
        return set;
    }
}
