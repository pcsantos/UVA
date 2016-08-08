import java.io.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < numberOfTestCases; i++) {
            String number = input.readLine();
            int times = 0;
            do {
                number = reverseAndAdd(number);
                times++;
            } while (isNotPalindrome(number));
            System.out.println(times + " " + number);
        }
        input.close();
    }

    private static String reverseAndAdd(String number) {
        String reverse = new StringBuffer(number).reverse().toString();
        long addend1 = Integer.parseInt(number);
        long addend2 = Integer.parseInt(reverse);

        return "" + (addend1 + addend2);
    }

    private static boolean isNotPalindrome(String number) {
    
        String reverse = new StringBuffer(number).reverse().toString();
        if (number.equals(reverse))
            return false;
        return true;
    }
}
