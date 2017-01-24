import java.util.*;
import java.io.*;
import java.math.*;

class Main {

    private static HashMap<String, String> map = new HashMap<String, String>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in = input.readLine();
        StringTokenizer st = new StringTokenizer(in);
        int words = Integer.parseInt(st.nextToken());
        int descriptions = Integer.parseInt(st.nextToken());
        for (int i = 0; i < words; i++) {
            st = new StringTokenizer(input.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        for (int i = 0; i < descriptions; i++) { 
            BigInteger salary = BigInteger.ZERO;
            while (!(in = input.readLine()).trim().equals(".")) {
                st = new StringTokenizer(in);
                while (st.hasMoreTokens()) {
                    String key = st.nextToken();
                    if (map.containsKey(key)) 
                        salary = salary.add(new BigInteger(map.get(key)));
                }
            }
            System.out.println(salary.toString());
        }
        input.close();
    }
}
