#include<stdio.h>

int main(void) {
    int value;
    unsigned long middle;
    unsigned long sumThreeLast;
    unsigned long last;
    while (scanf("%d\n", &value) != EOF) {
        last = value - 1;
        middle = last * ((value + 1) / 2) + 1;
        sumThreeLast = 3 * middle + 3 * last - 6;
        printf("%lu\n", sumThreeLast);
    }
    return 0;
}
