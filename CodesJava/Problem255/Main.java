import java.util.*;
import java.io.*;

class Main {
    private static int kingRow;
    private static int kingCol;
    private static int queenRow;
    private static int queenCol;

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            process(in);
        }
        input.close();
    }

    private static void process(String in) {
        StringTokenizer st = new StringTokenizer(in);
        int kingPos = Integer.parseInt(st.nextToken());
        int queenCurrentPos = Integer.parseInt(st.nextToken());
        int queenNextPos = Integer.parseInt(st.nextToken());
        kingRow = kingPos / 8;
        kingCol = kingPos % 8;
        queenRow = queenCurrentPos / 8;
        queenCol = queenCurrentPos % 8;
        ArrayList<Integer> kingMoves = getKingMoves(kingPos);
        ArrayList<Integer> QueenMoves = getQueenMoves(queenCurrentPos);
    }

    private static ArrayList<Integer> getKingMoves(int position) {
        

        return null; 
    }
    
    private static ArrayList<Integer> getQueenMoves(int position) {
        
        return null; 
    }
}
