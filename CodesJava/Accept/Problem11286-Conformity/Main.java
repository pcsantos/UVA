import java.util.*;
import java.io.*;

class Main {

    private static HashMap<String, Integer> hMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int froshes;
        while (!(in = input.readLine()).trim().equals("0")) {
            froshes = Integer.parseInt(in);
            for (int i = 0; i < froshes; i++) {
                in = input.readLine();
                String key = getKey(in);
                if (hMap.containsKey(key)) {
                    int value = hMap.get(key);
                    hMap.put(key, ++value);
                } else
                    hMap.put(key, 1);
            }
            ArrayList<Integer> arr = new ArrayList<>();
            for (Integer v : hMap.values())
                arr.add(v);
            Collections.sort(arr);
            int maxValue = Collections.max(arr);
            Collections.reverse(arr);
            int occur = 0;
            for (Integer v : arr)
                if (maxValue == v) {
                    occur++;
                } else
                    break;
            if (occur == 1)
                System.out.println(maxValue);
            else
                System.out.println(maxValue * occur);
            hMap.clear();
        }
        input.close();
    }

    private static String getKey(String in) {
        StringTokenizer st = new StringTokenizer(in);
        String[] arr = new String[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (String s : arr)
            sb.append(s);
        return sb.toString();
    }
}
