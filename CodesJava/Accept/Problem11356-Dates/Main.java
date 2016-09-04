import java.util.*;
import java.io.*;

class Main {
    
    private static final int MONTHS = 12;
    private static String[] months = {"January", "February", "March", "April", "May", "June", "July", 
                                            "August", "September", "October", "November", "December"};

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        GregorianCalendar gc;
        String in;
        int days;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 1; i <= testCases; i++) {
            in = input.readLine();
            days = Integer.parseInt(input.readLine());
            StringTokenizer st = new StringTokenizer(in, "-");
            gc = new GregorianCalendar(Integer.parseInt(st.nextToken()),
                            getMonthNumber(st.nextToken()), Integer.parseInt(st.nextToken()));
            gc.add(GregorianCalendar.DAY_OF_MONTH, days);
            System.out.format("Case %d: %d-%s-%02d\n", i, gc.get(Calendar.YEAR), 
                    months[gc.get(Calendar.MONTH)], gc.get(Calendar.DAY_OF_MONTH));
        }
        input.close();
    }

    private static int getMonthNumber(String m) {
        for (int i = 0; i < MONTHS; i++)
            if (m.equals(months[i]))
                return i;
        return 0;
    }
}
