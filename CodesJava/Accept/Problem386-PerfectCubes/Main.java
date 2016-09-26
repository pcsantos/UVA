import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) {
    
        for (long a = 2; a <= 200; a++) {
            for (long b = 2; cube(b) < cube(a); b++)
                for (long c = b + 1;  cube(c) + cube(b) < cube(a); c++)
                    for (long d = c + 1; cube(d) + cube(c) + cube(b) <= cube(a); d++) {
                        if (cube(a) == (cube(b) + cube(c) + cube(d))) 
                            System.out.format("Cube = %d, Triple = (%d,%d,%d)\n", a, b, c, d);
                    }
        }
    }

    private static long cube(long x) {
        return x * x * x;
    }
}
