#include<stdio.h>

#define SIZE 101

void calcsquares();

int squares[SIZE];

int main(void) {
    int number;
    calcsquares();
    scanf("%d\n", &number);
    while(number) {
        printf("%d\n", squares[number]);
        scanf("%d\n", &number);
    }
    return 0;
}

void calcsquares() {
    int i;
    squares[0] = 0;
    for (i = 1; i < SIZE; i++) {
        squares[i] = squares[i-1] + i*i;
    }
}
