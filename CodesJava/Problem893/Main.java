import java.io.*;
import java.util.*;

class Main {

    private static final int DAYS_OF_REGULAR_YEAR = 365;
    private static final int DAYS_OF_LEAP_YEAR = 366;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder(25000);

        String in;
        final long startTime = System.currentTimeMillis();
        while ((in = input.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(in);
            int numberOfDays = Integer.parseInt(st.nextToken());    
            int dayOfMonth = Integer.parseInt(st.nextToken());    
            int month = Integer.parseInt(st.nextToken());    
            int year = Integer.parseInt(st.nextToken());
            String answer = getDate(numberOfDays, dayOfMonth, month, year);
            if (!in.equals("0 0 0 0")) {
                stringBuilder.append(answer);
                stringBuilder.append('\n');
            }
        }
        output.write(stringBuilder.toString());
        final long finalTime = System.currentTimeMillis();
        output.write("Final execution Time: " + (finalTime - startTime) + "\n");
        output.flush();
        output.close();
        input.close();
    }

    private static String getDate(int numberOfDays, int dayOfMonth, int month, int year) {
    
        Calendar cal = new GregorianCalendar(year, month-1, dayOfMonth);
        cal.add((GregorianCalendar.DAY_OF_MONTH), numberOfDays);
        return cal.get(Calendar.DAY_OF_MONTH) + " " + (cal.get(Calendar.MONTH)+1) + " " + cal.get(Calendar.YEAR);
    }
/*
    private static String getDate(int numberOfDays, int dayOfMonth, int month, int year) {

            if (numberOfDays == 0 && dayOfMonth == 0 && month == 0 && year == 0)
                return null;

            if (numberOfDays > DAYS_OF_REGULAR_YEAR) {
                switch (month) {
                    case 1: numberOfDays -= 31;
                    case 2:
                        if (isLeapYear(year))
                            numberOfDays -= 29;
                        else
                            numberOfDays -= 28;
                    case 3: numberOfDays -= 31;
                    case 4: numberOfDays -= 30;
                    case 5: numberOfDays -= 31;
                    case 6: numberOfDays -= 30;
                    case 7: numberOfDays -= 31;
                    case 8: numberOfDays -= 31;
                    case 9: numberOfDays -= 30;
                    case 10: numberOfDays -= 31;
                    case 11: numberOfDays -= 30;
                    case 12: numberOfDays -= 31;
                }
                year++;
            }
            numberOfDays += dayOfMonth;
            month = 1;
            do {
                if (isLeapYear(year)) {
                    if (numberOfDays - (DAYS_OF_LEAP_YEAR + 3 * DAYS_OF_REGULAR_YEAR) > 0) {
                        numberOfDays -= (DAYS_OF_LEAP_YEAR + 3 * DAYS_OF_REGULAR_YEAR);
                        year += 4;
                    } else {
                        if (numberOfDays - DAYS_OF_LEAP_YEAR > 0) {
                            numberOfDays -= DAYS_OF_LEAP_YEAR;
                            year++;
                        }
                    }
                } else {
                    if (numberOfDays - DAYS_OF_REGULAR_YEAR > 0) {
                        numberOfDays -= DAYS_OF_REGULAR_YEAR;
                        year++;
                    }
                }
            } while (numberOfDays > DAYS_OF_REGULAR_YEAR);

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
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }*/
}
