import java.util.*;
import java.io.*;

class Main {

    private static Map<String, Character> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        startMap(); 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            if (in.matches("\\d+"))
                System.out.println(decode(in));
            else
                System.out.println(code(in));
        }
        input.close();
    }

    private static String decode(String in) {
        StringBuilder sb = new StringBuilder(in);
        StringBuilder code = new StringBuilder();
        String str;
        while (true) {
            if (sb.length() == 2) {
                code.append(getChar(sb.toString()));
                break;
            }
            if (sb.length() == 3) {
                code.append(map.get(sb.toString()));
                break;
            }

            if (sb.length() > 2) {
                str = sb.substring(0, 3);
                if (map.containsKey(str)) {
                    code.append(map.get(str));
                    sb.delete(0,3);
                } else {
                    str = sb.substring(0, 2);
                    code.append(getChar(str));
                    sb.delete(0,2);
                }
            }
        }
        return code.reverse().toString();
    }

    private static String getChar(String in) {
        StringBuilder sb = new StringBuilder(in).reverse();
        int value = Integer.parseInt(sb.toString());
        return String.valueOf((char) value);
    }

    private static String code(String in) {
        char[] arr = in.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            String digit = new StringBuffer(String.valueOf((int)arr[i])).reverse().toString();
            sb.append(digit);
        }
        return sb.toString();
    }

    private static void startMap() {
        map.put("001", 'd');
        map.put("101", 'e');
        map.put("201", 'f');
        map.put("301", 'g');
        map.put("401", 'h');
        map.put("501", 'i');
        map.put("601", 'j');
        map.put("701", 'k');
        map.put("801", 'l');
        map.put("901", 'm');
        map.put("011", 'n');
        map.put("111", 'o');
        map.put("211", 'p');
        map.put("311", 'q');
        map.put("411", 'r');
        map.put("511", 's');
        map.put("611", 't');
        map.put("711", 'u');
        map.put("811", 'v');
        map.put("911", 'w');
        map.put("021", 'x');
        map.put("121", 'y');
        map.put("221", 'z');
    }
}
