import java.io.*;
import java.util.*;

public class Main {
    private static final int REGULAR_YEAR = 365;
    private static final int LEAP_YEAR = 366;
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
            if (answer != null)
                System.out.println(answer);
        } 
    }

    private static String getDate(int numberOfDays, int dayOfMonth, int month, int year) {
   
            if (numberOfDays == 0 && dayOfMonth == 0 && month == 0 && year == 0)
                return null;

            numberOfDays += dayOfMonth;

            while(true){
                for (int currentMonth = month; currentMonth < 13; currentMonth++) {
                    switch (currentMonth) {
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:    
                        case 12:
                            if (numberOfDays - 31 <= 0) {
                                return numberOfDays + " " + currentMonth + " " + year;
                            }
                            numberOfDays -= 31;
                            break;
                        case 2:
                            if (isLeapYear(year)) {
                                if (numberOfDays - 29 <= 0) {
                                    return numberOfDays + " " + currentMonth + " " + year;
                                } else {
                                    numberOfDays -= 29;
                                }  
                            } else {
                                if (numberOfDays - 28 <= 0) {
                                    return numberOfDays + " " + currentMonth + " " + year;
                                } else {
                                    numberOfDays -= 28;
                                }
                            }
                            break;
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            if (numberOfDays - 30 <= 0) {
                                return numberOfDays + " " + currentMonth + " " + year;
                            }
                            numberOfDays -= 30;
                            break;
                    }
                }
                month = 1;
                year++;
            }
    }

    private static boolean isLeapYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > REGULAR_YEAR;
    }
}
