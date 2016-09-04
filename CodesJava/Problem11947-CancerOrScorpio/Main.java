import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        Calendar gc = Calendar.getInstance();
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 1; i <= testCases; i++) {
            in = input.readLine();
            char[] s = in.toCharArray();
            int MM = (s[0]-'0') * 10 + s[1]-'0';
            int DD = (s[2]-'0') * 10 + s[3]-'0';
            int YY = (((s[4]-'0') * 10 + s[5]-'0') * 10 + s[6]-'0') * 10 + s[7]-'0';
            gc.set(YY, MM-1, DD);
            gc.add(Calendar.DAY_OF_MONTH, 40*7);
            DD = gc.get(Calendar.DATE);
            MM = gc.get(Calendar.MONTH) + 1;
            YY = gc.get(Calendar.YEAR);
    
            String zodiac = "capricorn";
            if (gc.compareTo(new GregorianCalendar(YY, 0, 21)) >= 0) zodiac = "aquarius";
            if (gc.compareTo(new GregorianCalendar(YY, 1, 20)) >= 0) zodiac = "pisces";
            if (gc.compareTo(new GregorianCalendar(YY, 2, 21)) >= 0) zodiac = "aries";
            if (gc.compareTo(new GregorianCalendar(YY, 3, 21)) >= 0) zodiac = "taurus";
            if (gc.compareTo(new GregorianCalendar(YY, 4, 22)) >= 0) zodiac = "gemini";
            if (gc.compareTo(new GregorianCalendar(YY, 5, 22)) >= 0) zodiac = "cancer";
            if (gc.compareTo(new GregorianCalendar(YY, 6, 23)) >= 0) zodiac = "leo";
            if (gc.compareTo(new GregorianCalendar(YY, 7, 22)) >= 0) zodiac = "virgo";
            if (gc.compareTo(new GregorianCalendar(YY, 8, 24)) >= 0) zodiac = "libra";
            if (gc.compareTo(new GregorianCalendar(YY, 9, 24)) >= 0) zodiac = "scorpio";
            if (gc.compareTo(new GregorianCalendar(YY, 10, 23)) >= 0) zodiac = "sagittarius";
            if (gc.compareTo(new GregorianCalendar(YY, 11, 23)) >= 0) zodiac = "capricorn";

            System.out.format("%d %02d/%02d/%04d %s\n", i, MM, DD, YY, zodiac);
        }
        input.close();
    }
}
