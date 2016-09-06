import java.util.*;
import java.io.*;

class Main {

    private static final int MIN = 60;
    private static final double CONVERTION = 0.5;
    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        int hours, minutes, hoursInMinutes;
        while (!(in = input.readLine()).equals("0:00")) {
            StringTokenizer st = new StringTokenizer(in, ":");
            hours = Integer.parseInt(st.nextToken());
            minutes = Integer.parseInt(st.nextToken());
            hoursInMinutes = (12 - hours) *  MIN;
            System.out.format("%.3f\n", getDegrees(hoursInMinutes, minutes));
        }
        input.close();
    }

    private static double getDegrees(int hourInMin, int min) {
        int total = hourInMin - min;
        double degrees = 0;
        
        return degrees;
    }
}
