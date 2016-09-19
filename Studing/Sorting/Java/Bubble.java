import java.util.*;

class Bubble {
    
    private static final int SIZE = 50;

    public static void main(String[] args) {
        int[] arr = getArr();
        print(arr);
        bubble(arr);
        print(arr);
    }

    private static int[] getArr() {
        int[] arr = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < SIZE; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void bubble(int[] arr) {
        for (int i = SIZE - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }
}
