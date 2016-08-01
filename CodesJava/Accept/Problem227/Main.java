import java.util.*;
import java.io.*;

class Main {

    private static final int SIZE = 5;
    private static char[][] table;
    private static int blankLine = 0;
    private static int blankCol = 0;

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String[] in = new String[SIZE];
        int puzzleNumber = 1;
        while (!(in[0] = input.readLine()).equals("Z")) {
            if(puzzleNumber > 1)
                System.out.println();
            for (int i = 1; i < SIZE; i++) {
                in[i] = input.readLine(); 
            }
            table = getPuzzleTable(in);
            char move;
            boolean flag = true;
            while ((move = (char)input.read()) != '0') {
                if (move != '\n' && flag) {
                    if (!makeMove(move)) {
                        flag = false;
                    }
                }
            }
            input.read();
            System.out.println("Puzzle #" + (puzzleNumber++) + ":");
            if(flag)
                printTable();
            else
                System.out.println("This puzzle has no final configuration.");
        }
        input.close();
    }
  
    private static void printTable() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(table[i][j]);
                if (j < 4)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static boolean makeMove(char move) {
        switch (move) {
                case 'A':
                    if (!hasAbove()) return false;
                    table[blankLine][blankCol] = table[blankLine-1][blankCol];
                    table[--blankLine][blankCol] = ' ';
                    return true;
                case 'B':
                    if (!hasBelow()) return false;
                    table[blankLine][blankCol] = table[blankLine+1][blankCol];
                    table[++blankLine][blankCol] = ' ';
                    return true;
                case 'L':
                    if (!hasLeft()) return false;
                    table[blankLine][blankCol] = table[blankLine][blankCol-1];
                    table[blankLine][--blankCol] = ' ';
                    return true;
                case 'R':
                    if (!hasRight()) return false;
                    table[blankLine][blankCol] = table[blankLine][blankCol+1];
                    table[blankLine][++blankCol] = ' ';
                    return true;
        }
        return false;
    }

    private static boolean hasAbove() {
        if (blankLine - 1 >= 0) return true;
        return false;
    }
    
    private static boolean hasBelow() {
        if (blankLine + 1 < 5) return true;
        return false;
    }
    
    private static boolean hasLeft() {
        if (blankCol - 1 >=  0) return true;
        return false;
    }
    
    private static boolean hasRight() {
        if (blankCol + 1 < 5) return true;
        return false;
    }

    private static char[][] getPuzzleTable(String[] in) {
        
        char[][] table =  new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                table[i][j] = in[i].charAt(j);
                if (in[i].charAt(j) == ' ') {
                    blankLine = i;
                    blankCol = j;
                }
            }
        }
        return table;
    }
}
