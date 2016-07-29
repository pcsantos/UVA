import java.util.*;
import java.io.*;

class Main {

    private static int[] northSouth = {1, 2, 6, 5};
    private static int[] westEast = {1, 4, 6, 3};
    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in;
        while (!(in = input.readLine()).equals("0")) {
            int numberOfDirections = Integer.parseInt(in);
            for (int i = 0; i < numberOfDirections; i++) {
                String direction = input.readLine();
                rollDie(direction);
            }
            System.out.println(northSouth[0]);
            setArraysDefault();
        }

        input.close();
    }

    private static void setArraysDefault() {
        northSouth[0] = 1;
        northSouth[1] = 2;
        northSouth[2] = 6;
        northSouth[3] = 5;
        westEast[0] = 1;
        westEast[1] = 4;
        westEast[2] = 6;
        westEast[3] = 3;
    }

    private static void rollDie(String direction) {
    
        switch (direction) {
            case "north":
                moveNorth();
                break;
            case "east":
                moveEast();
                break;
            case "south":
                moveSouth();
                break;
            case "west":
                moveWest();
                break;
        }
    }

    private static void moveNorth() {
        
        int aux = northSouth[3];
        for (int i = 3; i > 0; i--) {
            northSouth[i] = northSouth[i - 1];
        }
        northSouth[0] = aux;
        westEast[2] = northSouth[2];
        westEast[0] = northSouth[0];
    }

    private static void moveEast() {
        
        int aux = westEast[3];
        for (int i = 3; i > 0; i--) {
            westEast[i] = westEast[i - 1];
        }
        westEast[0] = aux;
        northSouth[2] = westEast[2];
        northSouth[0] = westEast[0];
    }

    private static void moveSouth() {
        
        int aux = northSouth[0];
        for (int i = 0; i < 3; i++) {
            northSouth[i] = northSouth[i + 1];
        }
        northSouth[3] = aux;
        westEast[2] = northSouth[2];
        westEast[0] = northSouth[0];
    }
    
    private static void moveWest() {
        
        int aux = westEast[0];
        for (int i = 0; i < 3; i++) {
            westEast[i] = westEast[i + 1];
        }
        westEast[3] = aux;
        northSouth[2] = westEast[2];
        northSouth[0] = westEast[0];
    }
}
