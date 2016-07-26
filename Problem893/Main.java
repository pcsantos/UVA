import java.io.*;
import java.util.*;

public class Main {
    private final static int REGULAR_YEAR = 365;
    private final static int LEAP_YEAR = 366;
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
            return null;
    }
    public static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > REGULAR_YEAR;
    }
}
