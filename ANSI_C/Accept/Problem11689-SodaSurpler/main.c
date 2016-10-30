#include<stdio.h>

int main(void) {
    int testCases, i;
    int possBottles, foundBottles, cost; 
    int currentBottles;
    int total = 0;

    scanf("%d\n", &testCases);
    for (i = 0; i < testCases; i++) {
        scanf("%d %d %d\n", &possBottles, &foundBottles, &cost);
        currentBottles = possBottles + foundBottles;
        while (currentBottles >= cost) {
            total += currentBottles / cost;
            currentBottles = currentBottles / cost + currentBottles % cost;
        }
        printf("%d\n", total);
        total = 0;
    }
    return 0;
}
