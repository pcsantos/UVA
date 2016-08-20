import java.util.*;
import java.io.*;

class Main {

    private static String[] valuesList = new String[3000000];
    private static int size;

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String indexes;
        String values;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            if (i > 0)
                System.out.println();
            input.readLine();
            indexes = input.readLine();
            values = input.readLine();
            setArray(indexes, values);
            for (int j = 1; j < size; j++)
                System.out.println(valuesList[j]);
        }
        input.close();
    }

    private static void setArray(String indexes, String values) {
        size = 1;
        StringTokenizer in = new StringTokenizer(indexes);
        StringTokenizer v = new StringTokenizer(values);
        while (in.hasMoreTokens()) {
            valuesList[Integer.parseInt(in.nextToken())] =  v.nextToken();       
            size++;
        }
    }
}
