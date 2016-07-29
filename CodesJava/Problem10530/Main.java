import java.util.*;
import java.io.*;

class Main {

    private static List<Integer> tooHigh = new ArrayList<>();
    private static List<Integer> tooLow = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String answer = "";
        while (!(line = input.readLine()).equals("0")) {
            int number = Integer.parseInt(line);
            line = input.readLine();
            switch(line) {
                case "too high":
                    tooHigh.add(number);
                    break;
                case "too low":
                    tooLow.add(number);
                    break;
                case "right on":
                    answer = getAnswer(number);
                    System.out.println(answer);
                    tooHigh.clear();
                    tooLow.clear();
                    break;
            }
        }
        input.close();
    }

    private static String getAnswer(int number) {
        
        for (Integer n : tooHigh) {
            if (number >= n)
                return "Stan is dishonest";
        }
        for (Integer n : tooLow) {
            if (number <= n)
                return "Stan is dishonest";
        }
        return "Stan may be honest";
    }
}
