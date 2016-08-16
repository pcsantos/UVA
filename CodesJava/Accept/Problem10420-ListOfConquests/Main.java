import java.util.*;
import java.io.*;

class Main {
    private static ArrayList<Country> countries = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String line;
        int lines = Integer.parseInt(input.readLine());
        for (int i = 0; i < lines; i++) {
            line = input.readLine();
            StringTokenizer st = new StringTokenizer(line);
            addCountries(st.nextToken());
        }
        Collections.sort(countries);
        for (Country c : countries) {
            System.out.println(c.getName() + " " + c.getTimes());
        }
        input.close();
    }

    private static void addCountries(String country) {
        boolean insert = true;
        for (Country c : countries) {
            if (c.getName().equals(country)) {
                c.addTimes();
                insert = false;
                break;
            }
        }
        if (insert) {
            Country c = new Country(country);
            countries.add(c);
        }
    }
    
    static class Country implements Comparable<Country> {
        private String name;
        private int times;

        Country(String name) {
            this.name = name;
            this.times = 1;
        }

        String getName() {
            return this.name;
        }

        int getTimes() {
            return this.times;
        }

        void addTimes() {
            this.times++;
        }

        public int compareTo(Country another) {
            return this.name.compareTo(another.getName());
        }
    }
}
