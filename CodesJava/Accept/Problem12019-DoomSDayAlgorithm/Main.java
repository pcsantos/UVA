import java.util.*;
import java.io.*;

class Main {
    
    private static final int YEAR = 2011;
    private static final String[] daysOfWeek = {"","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        GregorianCalendar gc;
        String in;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            in = input.readLine();
            StringTokenizer st = new StringTokenizer(in);
            gc = new GregorianCalendar(YEAR, (Integer.parseInt(st.nextToken()) - 1),
                                                    Integer.parseInt(st.nextToken()));
            System.out.println(daysOfWeek[gc.get(Calendar.DAY_OF_WEEK)]);
        }

        input.close();
    }
}
