import java.util.*;

class Insertion {
    
    private static final int SIZE = 50;

    public static void main(String[] args) {
        int[] arr = getArr();
        print(arr);
        insertion(arr);
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

    private static void insertion(int[] arr) {
        for (int i = 1; i < SIZE; i++) {
            int value = arr[i];
            int index = i;
            while (index > 0 && arr[index - 1] > value) {
                swap(arr, index, index - 1);
                index--;
            }
            arr[index] = value;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }
}
