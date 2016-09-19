import java.util.*;

class QuickSort {
    
    private static final int SIZE = 50;

    public static void main(String[] args) {
        int[] arr = getArr();
        print(arr);
        quickSort(arr, 0, arr.length - 1);
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

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot)
                swap(arr, i, pIndex++);
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private static void swap(int[] arr, int a, int b) {
        int aux = arr[a];
        arr[a] = arr[b];
        arr[b] = aux;
    }
}
