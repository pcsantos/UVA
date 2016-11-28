#include<stdio.h>
#include<string.h>
#include<math.h>

#define SIZE 10000000
#define TRUE 1
#define FALSE 0

void prime();

int primes[SIZE + 1];

int main(void) {
    int value, i;
    int count = 0;
    memset(primes, TRUE, sizeof(primes));
    prime();
    while (scanf("%d\n", &value) != EOF) {
        printf("%d\n", value);
    }
    for (i = 0; i < SIZE / 4; i++) {
        if (primes[i])
            count++;
    }
    printf("%d \n", count);
    return 0;
}

void prime() {
    int i, j;
    primes[0] = FALSE;
    primes[1] = FALSE;
    for (i = 2; i <= sqrt(SIZE); i++) {
        if (primes[i]) {
            for (j = i; j * i < SIZE; j++) {
                primes[i * j] = FALSE;
            }
        }
    }
}
