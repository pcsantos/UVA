#include<stdio.h>
#include<math.h>

#define SIZE 1000000
#define TRUE 1
#define FALSE 0

void sieveOfEratosthenes();

int primes[SIZE + 1];

int main(void) {
    int number;
    int i;
    int a, b;
    sieveOfEratosthenes();
    scanf("%d\n", &number);
    while(number) {
        a = 0;
        b = 0;
        for (i = 3; i <= number/2; i++) {
            if (primes[i] && primes[number - i]) {
                a = i;
                b = number - i;
                break;
            }
        }
        if (a && b)
            printf("%d = %d + %d\n", number, a, b);
        else 
            printf("Goldbach's conjecture is wrong.\n");
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
