import java.util.*;

class MergeSort {
    
    private static final int SIZE = 50;

    public static void main(String[] args) {
        int[] arr = getArr();
        print(arr);
        mergeSort(arr);
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

    private static void mergeSort(int[] arr) {
        int size = arr.length;
        if(size < 2)
            return;
        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];
        for (int i = 0; i < mid; i++)
            left[i] = arr[i];
        for (int i = mid; i < size; i++)
            right[i - mid] = arr[i];
        mergeSort(left);
        mergeSort(right);
        mergeSort(left, right, arr);
    }

    private static void mergeSort(int[] left, int[] right, int arr[]) {
        int sizeLeft = left.length;
        int sizeRight = right.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < sizeLeft && j < sizeRight) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while (i < sizeLeft)
            arr[k++] = left[i++];
        while (j < sizeRight)
            arr[k++] = right[j++];
    }
}
