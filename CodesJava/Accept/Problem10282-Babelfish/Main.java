import java.util.*;
import java.io.*;

class Main {

    private static HashMap<String, String> dic = new HashMap<String, String>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in, key, value;
        while (!(in = input.readLine()).trim().equals("")) {
            StringTokenizer st = new StringTokenizer(in);
            value = st.nextToken();
            key = st.nextToken();
            dic.put(key, value);
        }
        while ((in = input.readLine()) != null) {
            if (dic.containsKey(in))
                System.out.println(dic.get(in));
            else
                System.out.println("eh");
        }
        input.close();
    }
}
