#include<stdio.h>

void sort(int[], int);
void bubble(int[], int);
void swap(int[], int, int);
void print(int[], int);

int main(void) {
    int arr[] = {9, 3, 2, 1, 4, 5, 8, 0, 6, 7};
    int size = 10;
    print(arr, size);
    bubble(arr, size);
    print(arr, size);

    return 0;
}

void bubble(int arr[], int size) {
    int i, j;
    for (i = size - 1; i >= 0; i--) {
        for (j = 0; j < i; j++) {
            if (arr[j] > arr[j + 1])
                swap(arr, j, j + 1);
        }
    }
}

void sort(int arr[], int size) {
    int i, j;
    int min = 0;

    for (i = 0; i < size - 1; i++) {
        min = i;
        for (j = i + 1; j < size; j++) {
            if (arr[min] > arr[j])
                min = j;
        }
        if (i != min)
            swap(arr, i, min);
    }
}

void print(int arr[], int size) {
    int i;
    for (i = 0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

void swap(int arr[], int i, int j) {
    int aux;
    aux = arr[i];
    arr[i] = arr[j];
    arr[j] = aux;
}
