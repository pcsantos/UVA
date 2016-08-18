import java.util.*;
import java.io.*;

class Main {
                
    private static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        int testCases = Integer.parseInt(input.readLine());     
        String in;
        for (int i = 0; i < testCases; i++) {
            boolean first = true;
            int size = 0;
            while (true) {
                in = input.readLine();
                if (first) {
                    size = getSizeAndSetFirstNumbers(in);
                    first = false;
                } else
                    setNumbers(in);
                if (size == numbers.size())
                    break;
            }
            float aboveAverage = findStudentsAboveAverage();
            System.out.format("%.3f%%\n", aboveAverage);
            numbers.clear();
        }
        input.close();
    }

    private static float findStudentsAboveAverage() {
    
        float average = 0;
        for (Integer number : numbers) {
            average += number;
        }
        average = average / numbers.size();
        int above = 0;
        for (Integer number : numbers) {
            if (average < number)
                above++;
        }
        if (above == 0)
            return 0;
        return (float) above / numbers.size() * 100;
    }


    private static int getSizeAndSetFirstNumbers(String in) {
        StringTokenizer st = new StringTokenizer(in);
        String str = st.nextToken();
        int size = Integer.parseInt(str);
        setNumbers(in.substring(str.length()));
        return size;
    }

    private static void setNumbers(String in) {
        StringTokenizer st = new StringTokenizer(in);
        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
    }
}
