import java.util.*;
import java.io.*;

class Main {

    private static TreeSet<String> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            char[] arr = in.trim().toLowerCase().toCharArray();
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (Character.isLetter(arr[i])) {
                    word.append(arr[i]);
                } else {
                    if (!word.toString().trim().equals(""))
                        set.add(word.toString());
                    while (i < arr.length && !Character.isLetter(arr[i]))
                        i++;
                    i--;
                    word = new StringBuilder();
                }
            }
        }
        Iterator it = set.iterator();
        while (it.hasNext())
            System.out.println(it.next());
        input.close();
    }
}
