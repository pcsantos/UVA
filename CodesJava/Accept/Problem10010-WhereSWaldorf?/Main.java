import java.util.*;
import java.io.*;

class Main {

    private static final int SIZE = 52;
    private static char[][] grid = new char[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        setGridToDefault();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        int testCases = Integer.parseInt(input.readLine());
        for (int i = 0; i < testCases; i++) {
            if (i > 0)
                System.out.println();
            input.readLine();
            in = input.readLine();
            StringTokenizer st = new StringTokenizer(in);
            int rows = Integer.parseInt(st.nextToken());
            int cols = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= rows; j++) {
                in = input.readLine();
                int n = 0;
                for (int m = 1; m <= cols; m++) {
                    grid[j][m] = Character.toUpperCase(in.charAt(n++));
                }
            }
            int numberOfWords = Integer.parseInt(input.readLine());
            for (int j = 0; j < numberOfWords; j++) {
                in = input.readLine();
                in = in.toUpperCase();
                String output = getOutput(rows, cols, in);
                System.out.println(output);
            }
        }
        input.close();
    }

    private static String getOutput(int rows, int cols, String name) {
    
        for (int i = 1; i <= rows; i++)
            for (int j = 1; j <= cols; j++) {
                if (getMatch(i, j, name)) {
                    return i + " " + j;       
                }
            }
        return null; 
    }

    private static boolean getMatch(int row, int col, String name) {
        boolean match = true;
        int k = 0;
        int i = row;
        int j = col;
        /*horizontally right */
        while (k < name.length()) {
            if(grid[i][j++] != name.charAt(k++)) {
                match = false;
                break;
            }
        }
        if (match) return true;
        
        match = true;
        k = 0;
        i = row;
        j = col;
        /*horizontally left */
        while (k < name.length()) {
            if(grid[i][j--] != name.charAt(k++)) {
                match = false;
                break;
            }
        }
        if (match) return true;

        match = true;
        k = 0;
        i = row;
        j = col;
        /*vertically down*/
        while (k < name.length()) {
            if(grid[i++][j] != name.charAt(k++)) {
                match = false;
                break;
            }
        }
        if (match) return true;

        match = true;
        k = 0;
        i = row;
        j = col;
        /*vertically up*/
        while (k < name.length()){
            if(grid[i--][j] != name.charAt(k++)) {
                match = false;
                break;
            }
        }
        if (match) return true;

        match = true;
        k = 0;
        i = row;
        j = col;
        /*diagonally right down*/
        while (k < name.length()){
            if(grid[i++][j++] != name.charAt(k++)) {
                match = false;
                break;
            }
        }
        if (match) return true;

        match = true;
        k = 0;
        i = row;
        j = col;
        /*diagonally left down*/
        while (k < name.length()) {
            if(grid[i++][j--] != name.charAt(k++)) {
                match = false;
                break;
            }
        }
        if (match) return true;
        
        match = true;
        k = 0;
        i = row;
        j = col;
        /*diagonally right up*/
        while (k < name.length()) {
            if(grid[i--][j++] != name.charAt(k++)) {
                match = false;
                break;
            }
        }       
        if (match) return true;
        
        match = true;
        k = 0;
        i = row;
        j = col;
        /*diagonally left up*/
        while (k < name.length()) {
            if(grid[i--][j--] != name.charAt(k++)) {
                match = false;
                break;
            }
        }       

        return match;
    }

    private static void setGridToDefault() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) 
                grid[i][j] = '@';
    }
}
