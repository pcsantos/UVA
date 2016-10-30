#include<stdio.h>

#define TRADE_COST 3

int main(void) {
    int bottles; 
    int currentBottles;
    int total = 0;
    int drank;

    scanf("%d\n", &bottles);
    while (bottles != 0 ) {
        currentBottles = bottles;
        while (currentBottles >= TRADE_COST) {
            drank = currentBottles / TRADE_COST;
            total += drank;
            currentBottles = currentBottles / TRADE_COST + currentBottles % TRADE_COST;
        }
        if (currentBottles == TRADE_COST - 1)
            total += 1;
        printf("%d\n", total);
        scanf("%d\n", &bottles);
        total = 0;
    }
    return 0;
}
