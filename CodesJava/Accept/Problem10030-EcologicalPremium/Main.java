import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            int farmers = Integer.parseInt(input.readLine());
            long totalReceived = 0;
            for (int j = 0; j < farmers; j++) {
                in = input.readLine();
                totalReceived += getFarmerPremium(in);
            }
            System.out.println(totalReceived);
        }
        input.close();
    }

    private static double getFarmerPremium(String in) {
        StringTokenizer st = new StringTokenizer(in);
        long sizeFarmyard = Long.parseLong(st.nextToken());
        long numberOfAnimals = Long.parseLong(st.nextToken());
        long farmerEnvFriendliness = Long.parseLong(st.nextToken());
        return sizeFarmyard * farmerEnvFriendliness;
    }
}
