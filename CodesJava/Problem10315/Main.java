import java.util.*;
import java.io.*;

class Main {

    private static final int STRAIGHT_FLUSH = 8;
    private static final int FOUR_OF_A_KIND = 7;
    private static final int FULL_HOUSE = 6;
    private static final int FLUSH = 5;
    private static final int STRAIGHT = 4;
    private static final int THREE_OF_A_KIND = 3;
    private static final int TWO_PAIRS = 2;
    private static final int PAIR = 1;
    private static final int HIGH_CARD = 0;

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            TreeMap<String, Integer> white = new TreeMap<String, Integer>();
            TreeMap<String, Integer> black = new TreeMap<String, Integer>();
            StringTokenizer st = new StringTokenizer(in);
            for (int i = 0; i < 5; i++) {
                String card = st.nextToken();
                String key = card;
                int value = getValue(card.charAt(0));
                white.put(key, value);
            }
            for (int i = 0; i < 5; i++) {
                String card = st.nextToken();
                String key = card;
                int value = getValue(card.charAt(0));
                black.put(key, value);
            }
            int whiteHandForce = verifyHandForce(white);
            int blackHandForce = verifyHandForce(black);
            if (whiteHandForce > blackHandForce) {
                System.out.println("White wins.");
            } else if (whiteHandForce < blackHandForce) {
                System.out.println("Black wins.");
            } else {
                System.out.println("Verify if is tie or not");
            }
        }
        input.close();
    }

    private static int verifyHandForce(TreeMap<String, Integer> hand) {
       
        for (String key: hand.keySet()) {
            System.out.print(key);
            System.out.print("  " + hand.get(key) + "  ");
        }
        System.out.println();
       
        if (isStraight(hand)) 
            if (isFlush(hand))
                return STRAIGHT_FLUSH;

        if (isFourOfAKind(hand))
            return FOUR_OF_A_KIND;

        if (isThreeOfAKind(hand))
            if (isOnePair(hand)) 
                return FULL_HOUSE;
        
        if (isFlush(hand))
            return FLUSH;

        if (isStraight(hand))
            return STRAIGHT;


        if (isThreeOfAKind(hand)) 
            return THREE_OF_A_KIND;

        if (isTwoPairs(hand))
            return TWO_PAIRS;

        if (isOnePair(hand))
            return PAIR;

        return HIGH_CARD; 
    }   

    private static boolean isStraight(TreeMap<String, Integer> hand) {
        
        Collection<Integer> list = hand.values();
        Integer[] values = new Integer[hand.size()];
        values = list.toArray(values);
        for (int i = 1; i < values.length; i++)
            if (values[i] != (values[i-1] + 1))
                return false;
        
        return true;
    }
    
    private static boolean isFlush(TreeMap<String, Integer> hand) {
       
        for (String key: hand.keySet()) {
            if (key.charAt(1) != hand.firstKey().charAt(1))
                return false;
        }
        return true; 
    }

    private static boolean isFourOfAKind(TreeMap<String, Integer> hand) {
        Collection<Integer> list = hand.values();
        Integer[] values = new Integer[hand.size()];
        values = list.toArray(values);
        for (int i = 0; i < values.length; i++) {
            int count = 0;
            for (int j = 0; j < values.length; j++) {
                if (values[i] == values[j]) {
                    count++;
                }
                if (count == 4) return true;
            }
        }
        return false;
    }

    private static boolean isThreeOfAKind(TreeMap<String, Integer> hand) {
        Collection<Integer> list = hand.values();
        Integer[] values = new Integer[hand.size()];
        values = list.toArray(values);
        for (int i = 0; i < values.length; i++) {
            int count = 0;
            for (int j = 0; j < values.length; j++) {
                if (values[i] == values[j]) {
                    count++;
                }
                if (count == 3) return true;
            }
        }
        return false;
    }
    
    private static boolean isOnePair(TreeMap<String, Integer> hand) {
        Collection<Integer> list = hand.values();
        Integer[] values = new Integer[hand.size()];
        values = list.toArray(values);
        for (int i = 0; i < values.length; i++) {
            int count = 0;
            for (int j = 0; j < values.length; j++) {
                if (values[i] == values[j]) {
                    count++;
                }
                if (count == 2) return true;
            }
        }
        return false;
    }
    
    private static boolean isTwoPairs(TreeMap<String, Integer> hand) {
        Collection<Integer> list = hand.values();
        Integer[] values = new Integer[hand.size()];
        values = list.toArray(values);

        Set<Integer> pairs = new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            pairs.add(values[i]);
        }
        if (pairs.size() == 3)
            return true;
        return false;
    }

    private static int getValue(char key) {
        switch (key) {
            case 'T':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
            default:
                return Integer.parseInt(key +"");
        } 
    }
}
