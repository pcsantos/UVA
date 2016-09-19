import java.util.*;

class Selection {
    
    private static final int SIZE = 50;

    public static void main(String[] args) {
        int[] arr = getArr();
        print(arr);
        selection(arr);
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

    private static void selection(int[] arr) {
        int min;
        for (int i = 0; i < SIZE - 1; i++) {
            min = i;
            for (int j = i + 1; j < SIZE; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            if (min != i)
                swap(arr, min, i);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }
}
