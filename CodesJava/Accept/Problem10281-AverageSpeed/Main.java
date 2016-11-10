import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        int currentSpeed = 0;
        String currentTime = "00:00:00";
        String nextTime;
        double time = 0.0;
        double total = 0.0;
        boolean first = true;

        while ((in = input.readLine())!= null) {
            StringTokenizer st = new StringTokenizer(in);
            if (st.countTokens() > 1) {
                if (first) {
                    nextTime = st.nextToken();
                    currentTime = nextTime;
                    time = getTime(currentTime, nextTime);
                    total += currentSpeed * time;
                    currentTime = nextTime;
                    currentSpeed = Integer.parseInt(st.nextToken());
                    first = false;
                } else {
                    nextTime = st.nextToken();
                    time = getTime(currentTime, nextTime);
                    total += currentSpeed * time;
                    currentTime = nextTime;
                    currentSpeed = Integer.parseInt(st.nextToken());
                }
            } else {
                if (first) {
                    nextTime = st.nextToken();
                    currentTime = nextTime;
                    time = getTime(currentTime, nextTime);
                    total += currentSpeed * time;
                    currentTime = nextTime;
                    System.out.format("%s %.2f km\n", currentTime, total);
                    first = false; 
                } else {
                    nextTime = st.nextToken();
                    time = getTime(currentTime, nextTime);
                    total += currentSpeed * time;
                    currentTime = nextTime;
                    System.out.format("%s %.2f km\n", currentTime, total);
                }
            }
        }
        input.close();
    }

    private static double getTime(String cTime, String nTime) {
        StringTokenizer st1 = new StringTokenizer(cTime, ":");
        StringTokenizer st2 = new StringTokenizer(nTime, ":");
        int st1Hour = Integer.parseInt(st1.nextToken());
        int st1Min = Integer.parseInt(st1.nextToken());
        int st1Sec = Integer.parseInt(st1.nextToken());
        double st1Time = st1Hour + st1Min / 60.00 + st1Sec / 3600.00;

        int st2Hour = Integer.parseInt(st2.nextToken());
        int st2Min = Integer.parseInt(st2.nextToken());
        int st2Sec = Integer.parseInt(st2.nextToken());
        double st2Time = st2Hour + st2Min / 60.00 + st2Sec / 3600.00;

        return st2Time - st1Time;
    }
}
