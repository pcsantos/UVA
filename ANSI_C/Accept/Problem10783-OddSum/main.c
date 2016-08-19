#include<stdio.h>

#define RANGE 101

void sumOdd();

int sumOddNumbers[RANGE];

int main(void) {
    sumOdd();
    int testCases;
    int min, max;
    int i;
    scanf("%d\n", &testCases);
    for (i = 1 ; i <= testCases; i++) {
        scanf("%d %d", &min, &max);
        printf("Case %d: %d\n", i, sumOddNumbers[max] - sumOddNumbers[min - 1]);
    }
    return 0;
}

void sumOdd() {
    int i;
    int aux;
    sumOddNumbers[0] = 0;
    sumOddNumbers[1] = 1;
    for (i = 2; i < RANGE; i++) {
        if (i % 2) {
            sumOddNumbers[i] = sumOddNumbers[i - 2] + i;
        } else
            sumOddNumbers[i] = sumOddNumbers[i - 1];
    }
}
