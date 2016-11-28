#include<stdio.h>

#define SIZE 50

long male[SIZE];
long female[SIZE];

void initMaleAndFemale();

int main(void) {
    int years;
    initMaleAndFemale();
    scanf("%d\n", &years);
    while (years != -1) {
        printf("%ld %ld\n", male[years], male[years] + female[years]);
        scanf("%d\n", &years);
    }
    return 0;
}

void initMaleAndFemale() {
    int i;
    female[0] = 1;
    female[1] = 1;
    male[0] = 0;
    male[1] = 1;
    for (i = 2; i < SIZE; i++) {
        female[i] = female[i - 1] + female[i - 2];
        male[i] = male[i - 1] + female[i - 1];
    }
}
