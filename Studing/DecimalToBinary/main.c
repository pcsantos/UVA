#include<stdio.h>

void toBinary(int);

int main(void) {
    int number;
    scanf("%d", &number);
    while(number >= 0) {
        toBinary(number);
        scanf("%d", &number);
    }
    return 0;
}

void toBinary(int number) {
    int v = 1;
    while (v <= number / 2)
        v *= 2;
    int n = number;
    while (v > 0) {
        if (n < v)
            printf("0");
        else {
            printf("1");
            n -= v;
        }
        v /= 2;
    }
    printf("\n");
}
