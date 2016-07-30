import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            String out = getOutput(in);
            System.out.println(out);
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

        int maxValue = Collections.max(arrayList); 
        int[] array = new int[arrayList.size()];

        int j = 0;
        for (Integer value : arrayList) {
            array[j++] = (int) value;
        }

        for (int i = 0; i < arrayList.size() - 1; i++) {
            int abs = Math.abs(array[i]-array[i+1]);
            if (abs > maxValue)
                return "Not jolly";
        }

        return "Jolly";
    }
}
