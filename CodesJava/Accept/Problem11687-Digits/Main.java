import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while (!(in = input.readLine()).equals("END")) {
            int out = getSmallerIndex(in);
            System.out.println(out);
        }
        input.close();
    }

    private static int getSmallerIndex(String in) {
      
        if (in.equals("1")) return 1;
        int i = 1;
        int current;
        int aux;
        while (true) {
            current = in.length();
            in = String.valueOf(current);
            i++;
            aux = in.length();
            if (aux == current)
                break;
        }
        return i;
    }
}
