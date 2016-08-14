import java.util.*;
import java.io.*;

class Main {
    private static final int SIZE = 50;
    private static char[][] grid = new char[SIZE][SIZE];
    private static ArrayList<Integer> coord = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        fillGrid(); 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while ((in = input.readLine()) != null) {
            setBuildingToGrid(in); 
            printGrid();
        }
        getCoord();
        input.close();
    }
    
    private static void getCoord() {
    
    }
    
    private static void setBuildingToGrid(String in) {
        StringTokenizer st = new StringTokenizer(in);
        int left = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int rigth = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= height; i++) {
            for (int j = left; j <= rigth; j++) {
                grid[i][j] = 'X';
            }
        }
    }

    private static void fillGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '0';
            }
        }   
    }

    private static void printGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }   
    }
}
