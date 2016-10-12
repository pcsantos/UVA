import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        int value = Integer.parseInt(args[0]);
        System.out.println(value);
        StringBuilder sb = new StringBuilder();
        do {
            if (value % 2 == 0)
                sb.append("0");
            else 
                sb.append("1");
            value /= 2;
        } while (value > 0);
        System.out.println(sb.reverse().toString());
    }
}
