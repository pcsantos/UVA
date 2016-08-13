import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder(25000);

        String in = input.readLine();
        while (in != null && !in.equals("0 0 0 0") ) {
            if (!in.equals("")) {
                StringTokenizer st = new StringTokenizer(in);
                int numberOfDays = Integer.parseInt(st.nextToken());    
                int dayOfMonth = Integer.parseInt(st.nextToken());    
                int month = Integer.parseInt(st.nextToken());    
                int year = Integer.parseInt(st.nextToken());
                String answer = getDate(numberOfDays, dayOfMonth, month, year);
                stringBuilder.append(answer);
                stringBuilder.append('\n');
                if (stringBuilder.length() > 24900) {
                    output.write(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }
            }
            in = input.readLine();
        }
        output.write(stringBuilder.toString());
        output.flush();
        output.close();
        input.close();
    }

    private static String getDate(int numberOfDays, int dayOfMonth, int month, int year) {
    
        Calendar cal = new GregorianCalendar(year, month-1, dayOfMonth);
        cal.add((GregorianCalendar.DAY_OF_MONTH), numberOfDays);
        return cal.get(Calendar.DAY_OF_MONTH) + " " + (cal.get(Calendar.MONTH)+1) + " " + cal.get(Calendar.YEAR);
    }
}
