import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            input.readLine();
            int tableSize = Integer.parseInt(input.readLine());
            String[] in = new String[tableSize];
            for (int j = 0; j < tableSize; j++) {
                in[j] = input.readLine();
            }
            
            int[][] bombs = getBombs(in, tableSize);
            for (int j = 0; j < tableSize; j++) {
                in[j] = input.readLine();
            }

            char[][] map = new char[tableSize][tableSize];
            for (int j = 0; j < tableSize; j++) {
                for (int k = 0; k < tableSize; k++) {
                    map[j][k] = in[j].charAt(k);
                }
            }
            verifyIfTouchBombsAndPrintOutput(bombs, map, tableSize);
            if (i < testCases - 1)
                System.out.println();
        }
        input.close();
    }

    private static void verifyIfTouchBombsAndPrintOutput(int bombs[][], char map[][], int tableSize) {
   
        boolean touch = touchBomb(bombs, map, tableSize);

        if (touch) {
            for (int i = 0; i < tableSize; i++) {
                for (int j = 0; j < tableSize; j++) {
                    if (bombs[i][j] == -1) {
                            System.out.print("*");
                    } else if (map[i][j] == 'x')
                        System.out.print(bombs[i][j]);
                    else
                        System.out.print(".");
                }
                System.out.println();
            }    
        } else {
            for (int i = 0; i < tableSize; i++) {
                for (int j = 0; j < tableSize; j++) {
                    if (map[i][j] == 'x')
                        System.out.print(bombs[i][j]);
                     else
                        System.out.print(".");
                }
                System.out.println();
            }    
        }
    }
    
    private static boolean touchBomb(int[][] bombs, char map[][], int tableSize) {
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                if (map[i][j] == 'x' && bombs[i][j] == -1)
                    return true;
            }
        } 
        return false; 
    }

    private static int[][] getBombs(String[] in, int tableSize) {
        char[][] bomb = new char[tableSize+2][tableSize+2];
        for (int i = 0; i < tableSize + 2; i++) {
            for (int j = 0; j < tableSize + 2; j++) {
                bomb[i][j] = '@';
            }            
        }


        for (int i = 1; i < tableSize + 1; i++) {
            for (int j = 1; j < tableSize + 1; j++) {
                bomb[i][j] = in[i - 1].charAt(j - 1);
            }            
        }

        return getTableWithNumbers(bomb, tableSize);
    }

    private static int[][] getTableWithNumbers(char[][] bomb, int tableSize) {
    
        int[][] out = new int[tableSize][tableSize];
            
        for (int i = 1; i < tableSize + 1; i++) {
            for (int j = 1; j < tableSize + 1; j++) {
                int count = 0;
                if (bomb[i][j] == '.') {
                    if (bomb[i-1][j] == '*') count++;
                    if (bomb[i-1][j-1] == '*') count++;
                    if (bomb[i-1][j+1] == '*') count++;
                    if (bomb[i][j-1] == '*') count++;
                    if (bomb[i][j+1] == '*') count++;
                    if (bomb[i+1][j-1] == '*') count++;
                    if (bomb[i+1][j] == '*') count++;
                    if (bomb[i+1][j+1] == '*') count++;
                    out[i-1][j-1] = count;
                } else if (bomb[i][j] == '*') {
                    count = -1;
                    out[i-1][j-1] = count;
                }
            }
        }
        return out;
    }
}
