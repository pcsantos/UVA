import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());     
        String in;
        for (int i = 0; i < testCases; i++) {
            in = input.readLine();
            int output = getDistance(in);
            System.out.println(output);
        }
        input.close();
    }

    private static int getDistance(String in) {
            
        StringTokenizer st = new StringTokenizer(in);
        int relatives = Integer.parseInt(st.nextToken());
        int[] relativeHouses = new int[relatives];
        for (int i = 0; i < relatives; i++) {
            relativeHouses[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(relativeHouses);
        int median = 0;
        if (relatives % 2 == 0)
            median = (relativeHouses[relatives / 2] + relativeHouses[(relatives / 2) - 1]) / 2;
        else
            median = relativeHouses[relatives / 2];

        int result = 0;
        for (int i = 0; i < relatives; i++) {
            result += Math.abs(relativeHouses[i] - median);
        }
        return result;
    }
}
