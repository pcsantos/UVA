#include<stdio.h>
#include<math.h>

#define MAXVALUE 10000
#define TRUE 1
#define FALSE 0

int primes[] = {2, 3, 5};

int isUgly(int);

int main (void) {
    int ith = 1;
    int number = 2;
    while (ith != 1500) {
        if (isUgly(number)) 
            ith++;
        number++;
    }
    printf("The 1500'th ugly number is %d.\n", --number);
    return 0;
}

int isUgly(int number) {
    int i;
    for (i = 0; i < 3; i++) {
        while(number % primes[i] == 0) {
            number /= primes[i];
        }
        if (number == 1)
            return TRUE;
    }
    return FALSE;
}
