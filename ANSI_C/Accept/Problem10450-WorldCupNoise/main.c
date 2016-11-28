#include<stdio.h>

#define SIZE 52

void initFibArr();

unsigned long long arr[SIZE];

int main(void) {
    int testCases;
    int value, i;
    initFibArr();
    scanf("%d\n", &testCases);
    for (i = 1; i <= testCases; i++) {
        scanf("%d\n", &value);
        printf("Scenario #%d:\n%llu\n\n", i, arr[value]);
    }
    return 0;
}

void initFibArr() {
    int i;
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 3;
    for (i = 3; i < SIZE; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
    }
}
