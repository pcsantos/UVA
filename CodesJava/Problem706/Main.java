import java.util.*;
import java.io.*;

class Main {

    private static int row = 0;
    private static int column = 0;
    private static int columnIndividualSize = 0;
    private static char[][] display;
    private static int currentColPosition = 0;
    private static int currentSize = 0;

    public static void main(String[] args) throws IOException {
    
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));    
        String in;
        while (!(in = input.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(in);
            int size = Integer.parseInt(st.nextToken());
            String number = st.nextToken();
            column = (size + 2) * number.length() + number.length() - 1;
            row = 2 * size + 3;
            columnIndividualSize = size + 2;
            currentSize = size;
            displayNumber(number);
        }
        input.close();
    }

    private static void displayNumber(String number) {
        currentColPosition = 0;
        display =  new char[row][column];

        setInitialDisplay();

        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            switch (digit) {
                case '0':
                    zero();
                    break;
                case '1':
                    one();
                    break;
                case '2':
                    two();
                    break;
                case '3':
                    three();
                    break;
                case '4':
                    four();
                    break;
                case '5':
                    five();
                    break;
                case '6':
                    six();
                    break;
                case '7':
                    seven();
                    break;
                case '8':
                    eight();
                    break;
                case '9':
                    nine();
                    break;
            }
        }
        printDisplay();
        System.out.println();
    }
    
    private static void zero() {
        int colLim = columnIndividualSize + currentColPosition;
        for (int i = 0; i < row; i++) {
            for (int j = currentColPosition; j < colLim; j++) {
                if(((i == 0) || (i == row - 1)) && (j > currentColPosition) && (j < colLim - 1)) {
                    display[i][j] = '-';
                }
                if (((i % (currentSize+1))!= 0) && ((j == currentColPosition) || (j == colLim - 1))) {
                    display[i][j] = '|';
                }
            }
        }
        currentColPosition += currentSize + 3;
    }

    private static void one() {
        int colLim = columnIndividualSize + currentColPosition;
        for (int i = 0; i < row; i++) {
            for (int j = currentColPosition; j < colLim; j++) {
                if (((i % (currentSize+1))!= 0) && (j == colLim - 1)) {
                    display[i][j] = '|';
                }
            }
        }
        currentColPosition += currentSize + 3;
    }
    
    private static void two() {
        int colLim = columnIndividualSize + currentColPosition;
        for (int i = 0; i < row; i++) {
            for (int j = currentColPosition; j < colLim; j++) {
                if(((i % (currentSize+1)) == 0) && (j > currentColPosition) && (j < colLim - 1)) {
                    display[i][j] = '-';
                }
                if (((i % (currentSize+1))!= 0) && ((j == currentColPosition && i > currentSize) 
                    || (j == colLim - 1 && i < currentSize + 1))) {
                    display[i][j] = '|';
                }
            }
        }
        currentColPosition += currentSize + 3;
    }
    
    private static void three() {
        int colLim = columnIndividualSize + currentColPosition;
        for (int i = 0; i < row; i++) {
            for (int j = currentColPosition; j < colLim; j++) {
                if(((i % (currentSize+1)) == 0) && (j > currentColPosition) && (j < colLim - 1)) {
                    display[i][j] = '-';
                }
                if (((i % (currentSize+1))!= 0) && (j == colLim - 1)) {
                    display[i][j] = '|';
                }
            }
        }
        currentColPosition += currentSize + 3;
    }
    
    private static void four() {
        int colLim = columnIndividualSize + currentColPosition;
        for (int i = 0; i < row; i++) {
            for (int j = currentColPosition; j < colLim; j++) {
                if(((i % (currentSize + 1) == 0) && (i != 0) && (i != row - 1)) 
                        && (j > currentColPosition) && (j < colLim - 1)) {
                    display[i][j] = '-';
                }
                if (((i % (currentSize+1))!= 0) && ((j == colLim - 1) || 
                        ( j == currentColPosition && i < currentSize + 1))) {
                    display[i][j] = '|';
                }
            }
        }
        currentColPosition += currentSize + 3;
    }
    
    private static void five() {
        int colLim = columnIndividualSize + currentColPosition;
        for (int i = 0; i < row; i++) {
            for (int j = currentColPosition; j < colLim; j++) {
                if(((i % (currentSize+1)) == 0) && (j > currentColPosition) && (j < colLim - 1)) {
                    display[i][j] = '-';
                }
                if (((i % (currentSize+1))!= 0) && ((j == currentColPosition && i < currentSize + 1) 
                    || (j == colLim - 1 && i > currentSize))) {
                    display[i][j] = '|';
                }
            }
        }
        currentColPosition += currentSize + 3;
    }
    
    private static void six() {
        int colLim = columnIndividualSize + currentColPosition;
        for (int i = 0; i < row; i++) {
            for (int j = currentColPosition; j < colLim; j++) {
                if(((i % (currentSize+1)) == 0) && (j > currentColPosition) && (j < colLim - 1)) {
                    display[i][j] = '-';
                }
                if (((i % (currentSize+1))!= 0) && ((j == currentColPosition) 
                    || (j == colLim - 1 && i > currentSize))) {
                    display[i][j] = '|';
                }
            }
        }
        currentColPosition += currentSize + 3;
    }
    
    private static void seven() {
        int colLim = columnIndividualSize + currentColPosition;
        for (int i = 0; i < row; i++) {
            for (int j = currentColPosition; j < colLim; j++) {
                if((i == 0) && (j > currentColPosition) && (j < colLim - 1)) {
                    display[i][j] = '-';
                }
                if (((i % (currentSize+1))!= 0) && (j == colLim - 1)) {
                    display[i][j] = '|';
                }
            }
        }
        currentColPosition += currentSize + 3;
    }

    private static void eight() {
        int colLim = columnIndividualSize + currentColPosition;
        for (int i = 0; i < row; i++) {
            for (int j = currentColPosition; j < colLim; j++) {
                if(((i % (currentSize+1)) == 0) && (j > currentColPosition) && (j < colLim - 1)) {
                    display[i][j] = '-';
                }
                if (((i % (currentSize+1))!= 0) && ((j == currentColPosition) || (j == colLim - 1))) {
                    display[i][j] = '|';
                }
            }
        }
        currentColPosition += currentSize + 3;
    }
    
    private static void nine() {
        int colLim = columnIndividualSize + currentColPosition;
        for (int i = 0; i < row; i++) {
            for (int j = currentColPosition; j < colLim; j++) {
                if(((i % (currentSize+1)) == 0) && (j > currentColPosition) && (j < colLim - 1)) {
                    display[i][j] = '-';
                }
                if (((i % (currentSize+1))!= 0) && ((j == currentColPosition && i < currentSize + 1) || (j == colLim - 1))) {
                    display[i][j] = '|';
                }
            }
        }
        currentColPosition += currentSize + 3;
    }

    private static void setInitialDisplay() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                display[i][j] = ' ';
            }
        }
    }
    
    private static void printDisplay() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(display[i][j]);
            }
            System.out.println();
        }
    }
}
