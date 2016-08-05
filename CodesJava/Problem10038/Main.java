import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            String out = getOutput(in);
            //System.out.println(out);
        }
        input.close();
    }

    private static String getOutput(String in) {
    
        List<Integer> arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(in);
        while(st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            arrayList.add(value);
        }
        int min = Collections.min(arrayList);
        int max = Collections.max(arrayList);

        Set<Integer> diffBetweenNumbers = new HashSet<>();
        for (int i = 1; i < arrayList.size(); i++) {
            int value = Math.abs(arrayList.get(i) - arrayList.get(i-1));
            System.out.print(value + " ");
            //if (diffBetweenNumbers.contains(value))
              //  return "Not Jolly";
            diffBetweenNumbers.add(value);
        }
        System.out.println();
        
        /*Iterator it = diffBetweenNumbers.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + "  ");
        }
        System.out.println();*/

        return "Jolly";
    }
}
