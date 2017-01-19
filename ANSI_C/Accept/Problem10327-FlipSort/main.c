#include<stdio.h>
#include<string.h>

#define SIZE 1001

int bubbleFlips(int[], int);
void swap(int[], int, int);

int main(void) {
    int nElements;
    int i, j;
    int arr[SIZE];

    while (scanf("%d\n", &nElements) != EOF) {
        for (i = 0; i < nElements; i++) {
            scanf("%d", &arr[i]);
        }
        printf("Minimum exchange operations : %d\n", bubbleFlips(arr, nElements));    
    }

    return 0;
}

int bubbleFlips(int arr[], int nElements) {
    int i, j;
    int flip = 0;
    for (i = nElements - 1; i >= 1; i--) {
        for (j = 0; j < i; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr, j, j + 1);
                flip++;
            }
        }
    }
    return flip;
}

void swap(int arr[], int a, int b) {
    int aux;
    aux = arr[a];
    arr[a] = arr[b];
    arr[b] = aux;
}
