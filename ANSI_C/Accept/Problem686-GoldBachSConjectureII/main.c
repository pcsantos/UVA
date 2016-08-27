#include<stdio.h>
#include<math.h>

#define SIZE 32800
#define TRUE 1
#define FALSE 0

void sieveOfEratosthenes();

int primes[SIZE + 1];

int main(void) {
    int number;
    int i;
    int count;
    sieveOfEratosthenes();
    scanf("%d\n", &number);
    while(number) {
        count = 0;
        for (i = 2; i <= number/2; i++) {
            if (primes[i] && primes[number - i])
                count++;
        }
        printf("%d\n", count);
        scanf("%d\n", &number);
    }

    return 0;
}

void sieveOfEratosthenes() {
    int i, j;
    primes[0] = FALSE;
    primes[1] = FALSE;
    for (i = 2; i <= SIZE; i++)
        primes[i] = TRUE;
    for (i = 2; i <= sqrt(SIZE); i++) {
        if (primes[i]) {
            for (j = i; j * i <= SIZE; j++)
                primes[j * i] = FALSE;
        }
    }
}
