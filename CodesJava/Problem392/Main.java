import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while ((in = input.readLine()) != null) {
            System.out.println(result(in));
        }
        input.close();
    }

    private static String result(String in) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in);
        int term = 8;
        boolean first = true;
        while (st.hasMoreTokens()) {
            String coef = st.nextToken();
            if (!coef.equals("0") && !coef.equals("-0")) {
                sb.append(format(coef, term, first));
                first = false;
            }
            term--;
        }
        if (first)
            return "0";
        return sb.toString().trim();
    }

    private static String format(String in, int term, boolean first) {
        if (term == 0 && first) {
            if (in.contains("-"))
                return "-" + in.substring(1);
            else
                return in;
        }
        if (term == 0) {
            if (in.contains("-"))
                return "- " + in.substring(1);
            else
                return "+ " + in;
        }

        if (term == 1 && first) {
            if (in.contains("-")) {
                if (in.substring(1).equals("1")) 
                    return "-x ";
                else 
                    return "-" + in.substring(1) + "x ";
            } else {
                if (in.equals("1"))
                    return "x ";
                else
                    return in + "x ";
            }
        }
        if (term == 1) {
            if (in.contains("-")) {
                if (in.substring(1).equals("1"))
                    return "- x ";
                else
                    return "- " + in.substring(1) + "x ";
            } else {
                if (in.equals("1"))
                    return "+ x ";
                else
                    return "+ " + in + "x ";
            }

        }
        if (in.contains("-") && first) {
            if (in.substring(1).equals("1"))
                return "-x^" + term + " ";
            else
                return "-" + in.substring(1) + "x^" + term + " ";
        }
        if (in.contains("-")) {
            if (in.substring(1).equals("1"))
                return "- x^" + term + " ";
            else
                return "- " + in.substring(1) + "x^" + term + " ";
        }
        if (first) {
            if (in.equals("1"))
                return "x^" + term + " ";
            else
                return in + "^" + term + " ";
        }
        if (in.equals("1"))
            return "+ x^" + term + " ";
        else
            return "+ " + in + "x^" + term + " ";

    }
}
