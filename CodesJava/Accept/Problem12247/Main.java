import java.util.*;
import java.io.*;

class Main {

    private static List<Integer> princess = new ArrayList<>();
    private static List<Integer> prince = new ArrayList<>();
    private static boolean[] cards = new boolean[53];

    public static void main(String[] args) throws IOException {
    
        for (int i = 0; i < 53; i++) {
            cards[i] = true;
        }

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = input.readLine()) != null) {
            if(!parseIn(line))
                break;
            int out = getOutput();
            System.out.println(out);
            setCardsArrayToDefault();
        }
        input.close();
    }

    private static void setCardsArrayToDefault() {
        
        for (Integer card : princess) {
            cards[card] = true;
        }
        for (Integer card : prince) {
            cards[card] = true;
        }
        princess.clear();
        prince.clear();
    }

    private static boolean parseIn(String line) {
    
        StringTokenizer st = new StringTokenizer(line);    
        for (int i = 0; i < 3; i++) {
            int card = Integer.parseInt(st.nextToken());
            if (card == 0) return false;
            princess.add(card);
            cards[card] = false;
        }
        for (int i = 0; i < 2; i++) {
            int card = Integer.parseInt(st.nextToken());
            prince.add(card);
            cards[card] = false;
        }
        return true;
    }

    private static int getOutput() {
        Collections.sort(princess);
        Collections.sort(prince);

        if (isBiggerThanAll(prince.get(1))) {
            if (isBiggerThanAll(prince.get(0))) {
                return pickAnyCard();
            } else if (isSmallerThanOne(prince.get(0))) {
                return pickOneBiggerThanTwo();
            } else {
                return pickTheBiggerCard();
            }
        }
        if (isSmallerThanOne(prince.get(1)))
            if (isSmallerThanOne(prince.get(0)))
                return pickOneBiggerThanTwo();

        return -1;
    }

    private static boolean isBiggerThanAll(int value) {
        for (Integer cardValue: princess) {
            if (cardValue > value)
                return false;
        }       
        return true;
    }
    
    private static boolean isSmallerThanOne(int value) {

        int count = 0;

        for (Integer cardValue : princess) {
            if (cardValue > value)
                count++;
        }
        if (count == 1)
            return true;
        return false;
    }

    private static int pickAnyCard() {

        for (int i = 1; i < 53; i++) {
            if (cards[i])
                return i;
        }
        return -1;      
    }
    
    private static int pickOneBiggerThanTwo() {

        int princessMiddleCard = princess.get(1);
        for (int i = princessMiddleCard + 1; i < 53; i++) {
            if (cards[i])
                return i;
        }
        return -1;
    }
    
    private static int pickTheBiggerCard() {

        int princessBiggerCard = princess.get(2);
        if (princessBiggerCard > 51) return -1;
        for (int i = princessBiggerCard + 1; i < 53; i++) {
            if (cards[i])
                return i;
        }
        return -1;
    }
}
