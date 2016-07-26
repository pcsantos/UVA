import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while ((in = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(in);
            int numberOfDays = Integer.parseInt(st.nextToken());    
            int dayOfMonth = Integer.parseInt(st.nextToken());    
            int month = Integer.parseInt(st.nextToken());    
            int year = Integer.parseInt(st.nextToken());
            String answer = getDate(numberOfDays, dayOfMonth, month, year);
        } 
    }

    private static String getDate(int numberOfDays, int dayOfMonth, int month, int year) {
    
            boolean currentYear = isLeapYear(year);
            while()
            return null;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
            } else {
                return true;
            }
        }    
        return false;
    }
}
