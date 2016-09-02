import java.util.*;
import java.io.*;

class Main {
    
    private static ArrayList<Person> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in, name;
        int day, month, year;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            in = input.readLine();
            StringTokenizer st = new StringTokenizer(in);
            name = st.nextToken();
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
            Person person = new Person(name, new GregorianCalendar(year, month, day));
            arr.add(person);
        }
        Collections.sort(arr);
        System.out.println(Collections.max(arr).getName());
        System.out.println(Collections.min(arr).getName());

        input.close();
    }

    static class Person implements Comparable<Person> {
        private String name;
        private GregorianCalendar birth;
        Person(String name, GregorianCalendar birth) {
            this.name = name;
            this.birth = birth;
        }
        
        String getName() {
            return this.name;
        }

        GregorianCalendar getBirth() {
            return this.birth;
        }

        public int compareTo(Person another) {
            return this.birth.compareTo(another.getBirth());
        }
    }
}
