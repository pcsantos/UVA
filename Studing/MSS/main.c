#include<stdio.h>

#define SIZE 10

int Kadane(int[]);
int max(int, int);

int main(void) {
    int arr[SIZE] = {1, -3, 2, -5, 7, 6, -1, -4, 11, -23};

    printf("%d\n", Kadane(arr));

    return 0;
}

int Kadane(int arr[]) {
    int i;
    int maxCurrent;
    int maxGlobal;
    maxCurrent = maxGlobal = arr[0];
    for (i = 1; i < SIZE; i++) {
        maxCurrent = max(arr[i], (maxCurrent + arr[i]));
        if (maxCurrent > maxGlobal)
            maxGlobal = maxCurrent;
    }
    return maxGlobal;
}

int max(int a, int b) {
    return a > b ? a : b;
}
