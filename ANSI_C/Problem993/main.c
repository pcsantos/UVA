#include<stdio.h>
#include<stdlib.h>

#define SIZE 100
#define TRUE 1
#define FALSE 0

int setNumber(int,int*);
int setOut(int);
int cmp(const void*, const void*);

int arr[SIZE];
int out[SIZE];

int main(void) {
    int testCases;
    int value, size;
    int i, j, outLimit;

    scanf("%d\n", &testCases);
    for (i = 0; i < testCases; i++) {
        scanf("%d\n", &value);
        if (setNumber(value, &size)) {
            outLimit = setOut(size);
            qsort(out, outLimit, sizeof(int), cmp);
            for (j = 0; j < outLimit; j++)
                printf("%d", out[j]);
            printf("\n");
        } else {
            printf("-1\n");
        }
    }
    return 0;
}

int setNumber(int value, int *size) {
    int index = 0;
    *size = 0;
    if (value == 0) {
        arr[index] = 0;
        (*size)++;
        return TRUE;
    }
    if (value == 1) {
        arr[index] = 1;
        (*size)++;
        return TRUE;
    }
    while (value % 8 == 0) {
        arr[index++] = 8;
        (*size)++;
        value /= 8;
    }
    while (value % 2 == 0) {
        arr[index++] = 2;
        (*size)++;
        value /= 2;
    }
    while (value % 9 == 0) {
        arr[index++] = 9;
        (*size)++;
        value /= 9;
    }
    while (value % 3 == 0) {
        arr[index++] = 3;
        (*size)++;
        value /= 3;
    }
    while (value % 5 == 0) {
        arr[index++] = 5;
        (*size)++;
        value /= 5;
    }
    while (value % 7 == 0) {
        arr[index++] = 7;
        (*size)++;
        value /= 7;
    }
    if (value > 1) return FALSE;
    return TRUE;
}

int setOut(int size) {
    int i, j;
    int newSize = 1;
    j = 0;
    out[j] = arr[size - 1];
    for (i = size - 2; i >= 0; i--) {
        if (out[j] * arr[i] > 9) {
            out[++j] = arr[i];
            newSize++;
        } else {
            out[j] *= arr[i];
        }
    }
    return newSize;
}

int cmp(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}
