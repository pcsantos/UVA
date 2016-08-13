import java.util.*;

class Test {

    public static void main(String[] args) {
    
        Calendar cal = new GregorianCalendar(2016, 11, 12);

        System.out.println("Day of Month" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("Month" + cal.get(Calendar.MONTH));
        System.out.println("Year" + cal.get(Calendar.YEAR));
        
        cal.add(3,1);
        
        System.out.println("Day of Month" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("Month" + cal.get(Calendar.MONTH));
        System.out.println("Year" + cal.get(Calendar.YEAR));
    }
}
