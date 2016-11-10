#include<stdio.h>
#include<string.h>

#define SIZE 1000001
#define TRUE 1
#define FALSE 0

int sum(int);

int vet[SIZE];

int main(void) {
    int i, aux;
    int total;
    int divisor;
    memset(vet, 1, sizeof(vet));
    for (i = 1; i < SIZE; i++) {
        total = sum(i);
        if (total < 1000001)
            vet[total] = 0;
    }
    for (i = 1; i < SIZE; i++) {
        if (vet[i])
            printf("%d\n", i);
    }
    return 0;
}

int sum(int value) {
    char buff[7];
    int i, total;
    sprintf(buff, "%d", value);
    total = value;
    for (i = 0; buff[i]; i++) 
        total += buff[i] - '0';
    return total;
}
