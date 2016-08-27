import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        String out;
        while (!(in = input.readLine()).trim().equals("0")) {
            if (in.contains("-"))
                out = getOutput(in.replace("-", "")).replace(" ", " x ");
            else
                out = getOutput(in).replace(" ", " x ");
            if (in.contains("-"))
                System.out.println(in + " = -1 x " + out);
            else
                System.out.println(in + " = " + out);
        }
        input.close();
    }
    
    private static String getOutput(String in) {
        int number = Integer.parseInt(in);
        StringBuilder sb = new StringBuilder();
        while (number % 2 == 0) {
            sb.append(2 + " ");
            number /= 2;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                sb.append(i + " ");
                number /= i;
            }
        }
        if (number > 2)
            sb.append(number);

        return sb.toString().trim();
    }
}
