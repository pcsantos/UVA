import java.util.*;
import java.io.*;

class Main {

    private static Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));    
        OutputStreamWriter out = new OutputStreamWriter(System.out, "ISO-8859-1");
        String plainText;
        String subText;
        String in;
        int testCases = Integer.parseInt(input.readLine());
        input.readLine();
        for (int i = 0; i < testCases; i++) {
            if (i > 0)
                System.out.println();
            plainText = input.readLine();
            subText = input.readLine();
            startMap(plainText, subText);
            in = input.readLine();
            out.write(subText + "\n");
            out.write(plainText + "\n");
            out.flush();
            while (in != null && !in.trim().equals("")) {
                out.write(code(in) + "\n");
                out.flush();
                in = input.readLine();
            }
            map.clear();
        }
        out.close();
        input.close();
    }

    private static String code(String in) {
        StringBuilder sb = new StringBuilder();
        char[] arr = in.toCharArray();
        for (int i = 0; i < arr.length; i++)
        if (map.containsKey(arr[i]))
            sb.append(map.get(arr[i]));
        else
            sb.append(arr[i]);
        return sb.toString();
    }

    private static void startMap(String plainText, String subText) {
        char[] a = plainText.toCharArray();
        char[] b = subText.toCharArray();
        for (int i = 0; i < a.length; i++)
            map.put(a[i], b[i]);
    }
}
