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
    private static final int WHITE_WIN = 1;
    private static final int BLACK_WIN = 2;
    private static final int TIE = 0;

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
                black.put(key, value);
            }
            for (int i = 0; i < 5; i++) {
                String card = st.nextToken();
                String key = card;
                int value = getValue(card.charAt(0));
                white.put(key, value);
            }
            int whiteHandForce = verifyHandForce(white);
            int blackHandForce = verifyHandForce(black);
            if (whiteHandForce > blackHandForce) {
                System.out.println("White wins.");
            } else if (whiteHandForce < blackHandForce) {
                System.out.println("Black wins.");
            } else {
                switch (tieBreaker(white, black, blackHandForce)) {
                    case WHITE_WIN :
                        System.out.println("White wins.");
                        break;
                    case BLACK_WIN :
                        System.out.println("Black wins.");
                        break;
                    case TIE:
                        System.out.println("Tie.");
                        break;
                }
            }
        }
        input.close();
    }
    private static int tieBreaker(TreeMap<String, Integer> white, TreeMap<String, Integer> black, int handType) {
        Integer[] whiteValues = getArray(white);
        Integer[] blackValues = getArray(black);
        Arrays.sort(whiteValues);
        Arrays.sort(blackValues);
        switch (handType) {
            case STRAIGHT_FLUSH :
                return highCard(whiteValues, blackValues);
            case FOUR_OF_A_KIND :
                return fourOfAKindWinner(whiteValues, blackValues);
            case FULL_HOUSE :
                return threeOfAKindWinner(whiteValues, blackValues);
            case FLUSH :
                return highCard(whiteValues, blackValues);
            case STRAIGHT :
                return highCard(whiteValues, blackValues);
            case THREE_OF_A_KIND :
                return threeOfAKindWinner(whiteValues, blackValues);
            case TWO_PAIRS :
                return twoPairsWinner(whiteValues, blackValues);
            case PAIR :
                return onePairWinner(whiteValues, blackValues);
            case HIGH_CARD :
                return highCard(whiteValues, blackValues);
        }
        return TIE;
    }
    private static int twoPairsWinner(Integer[] white, Integer[] black) {
        int oneCardWhite = getRanked(white, 1);    
        int oneCardBlack = getRanked(black, 1);
        int[] b = new int[4];
        int[] w = new int[4];
        int j = 0;
        for (int i = 0; i < 5; i++) {
            if (oneCardWhite != white[i])
                w[j++] = white[i];
        }
        j = 0;
        for (int i = 0; i < 5; i++) {
            if (oneCardBlack != black[i])
                b[j++] = black[i];
        }
        if (w[3] > b[3])
            return WHITE_WIN;
        if (w[3] < b[3])
            return BLACK_WIN;
        if (w[0] > b[0])
            return WHITE_WIN;
        if (w[0] < b[0])
            return BLACK_WIN;
        if (oneCardWhite > oneCardBlack)
            return WHITE_WIN;
        if (oneCardWhite < oneCardBlack)
            return BLACK_WIN;
        return TIE;
    }

    private static int fourOfAKindWinner(Integer[] white, Integer[] black) {
        int whiteFour = getRanked(white, 4);
        int blackFour = getRanked(black, 4);
        if(whiteFour > blackFour)
            return WHITE_WIN;
        else if (whiteFour < blackFour)
            return BLACK_WIN;
        return TIE;
    }
    
    private static int threeOfAKindWinner(Integer[] white, Integer[] black) {
        int whiteThree = getRanked(white, 3);
        int blackThree = getRanked(black, 3);
        if(whiteThree > blackThree)
            return WHITE_WIN;
        if (whiteThree < blackThree)
            return BLACK_WIN;
        return TIE;
    }
    
    private static int onePairWinner(Integer[] white, Integer[] black) {
        int whitePair = getRanked(white, 2);
        int blackPair = getRanked(black, 2);
        if(whitePair > blackPair)
            return WHITE_WIN;
        if (whitePair < blackPair)
            return BLACK_WIN;
        return TIE;
    }

    private static int highCard(Integer[] white, Integer[] black) {
        for (int i = 4; i >= 0; i--) {
            if (white[i] > black[i])
                return WHITE_WIN;
            if (white[i] < black[i])
                return BLACK_WIN;
        }
        return TIE;
    }

    private static int getRanked(Integer[] values, int flag) {
        int cardValue = 0;
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (values[i] == values[j]) {
                    cardValue = values[i];
                    count++;
                }
            }
            if (count == flag) return cardValue;
        }
        return cardValue;
    }

    private static int verifyHandForce(TreeMap<String, Integer> hand) {
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
        Integer[] values = getArray(hand);
        Arrays.sort(values);
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
        Integer[] values = getArray(hand);
        if (countOccurence(values, 4))
            return true;
        return false;
    }

    private static boolean isThreeOfAKind(TreeMap<String, Integer> hand) {
        Integer[] values = getArray(hand);
        if (countOccurence(values, 3))
            return true;
        return false;
    }
    
    private static boolean isOnePair(TreeMap<String, Integer> hand) {
        Integer[] values = getArray(hand);
        if (countOccurence(values, 2))
            return true;
        return false;
    }
    
    private static boolean isTwoPairs(TreeMap<String, Integer> hand) {
        Integer[] values = getArray(hand);
        Set<Integer> pairs = new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            pairs.add(values[i]);
        }
        if (pairs.size() == 3)
            return true;
        return false;
    }
    
    private static boolean countOccurence(Integer[] values, int flag) {
        for (int i = 0; i < values.length; i++) {
            int count = 0;
            for (int j = 0; j < values.length; j++) {
                if (values[i] == values[j]) {
                    count++;
                }
                if (count == flag) return true;
            }
        }
        return false;
    }

    private static Integer[] getArray(TreeMap<String, Integer> hand) {
        Collection<Integer> list = hand.values();
        Integer[] values = new Integer[hand.size()];
        return list.toArray(values);
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
