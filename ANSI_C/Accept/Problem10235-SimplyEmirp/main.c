#include<stdio.h>
#include<math.h>

#define TRUE 1
#define FALSE 0
#define SIZE 1000001

void primeNumbers();
int reverseNumber(int);

int primes[SIZE];

int main(void) {
    primeNumbers();
    int number;
    while (scanf("%d \n", &number) != EOF) {
        int reverse = reverseNumber(number);
        if (primes[number]) {
            if (primes[reverse] && number != reverse) {
                printf("%d is emirp.\n", number);
            } else {
                printf("%d is prime.\n", number);
            }
        } else {
            printf("%d is not prime.\n", number);
        } 
    }

    return 0;
}

int reverseNumber(int number) {
    int value;
    int reverse = 0;
    do {
        value = number % 10;
        reverse = reverse * 10 + value;
        number /= 10;
    } while (number != 0);
    return reverse;
}

void primeNumbers() {
    int i, j;
    primes[0] = FALSE;
    primes[1] = FALSE;
    for (i = 2; i < SIZE; i++)
        primes[i] = TRUE;
    for (i = 2; i <= sqrt(SIZE - 1); i++) {
         if (primes[i]) {
            for (j = i; i * j < SIZE; j++)
                primes[i * j] = FALSE;
         }
    }
}
