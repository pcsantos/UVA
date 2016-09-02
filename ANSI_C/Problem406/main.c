#include<stdio.h>
#include<math.h>

#define TRUE 1
#define FALSE 0
#define SIZE 8000
#define RANGE 1001

void sieveOfEratosthenes();
void print(int, int);

int sieve[SIZE];
int primes[RANGE];

int main(void) {
    int upper, i;
    int range;
    int qtdPrimes;
    sieveOfEratosthenes();
    while (scanf("%d %d\n", &upper, &range) != EOF) {
        qtdPrimes = 0;
        for (i = 0; primes[i] <= upper; i++) {
            qtdPrimes++;
        }
    }
    return 0;
}

void sieveOfEratosthenes() {
    int i, j;
    sieve[0] = FALSE;
    for (i = 1; i < SIZE; i++)
        sieve[i] = TRUE;
    for (i = 2; i <= sqrt(SIZE - 1); i++) {
        if (sieve[i]) {
            for (j = i; j * i < SIZE; j++)
                sieve[j * i] = FALSE;
        }
    }
    j = 0;
    for(i = 0; i < SIZE; i++) {
        if (sieve[i])
            primes[j++] = i;
        if (j == RANGE)
            break;
    }
}
