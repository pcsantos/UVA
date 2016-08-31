#include<stdio.h>
#include<math.h>

#define TRUE 1
#define FALSE 0

unsigned int gcd(int, int);
unsigned int bigmod(unsigned int, unsigned int, unsigned int);
unsigned int square(int);
int isCarmichael(int);

int main(void) {
    int number;
    scanf("%d", &number);
    while (number) {
        if (isCarmichael(number))
            printf("The number %d is a Carmichael number.\n", number);
        else
            printf("%d is normal.\n", number);
        scanf("%d", &number);
    }

    return 0;
}

int isCarmichael(int number) {
    int b = 2;
    int s = sqrt(number);
    int factorFound = 0;
    if (number % 2 == 0)
        return FALSE;
    while (b < number) {
        if (b > s && !factorFound) {
            return FALSE;
        }
        if (gcd(b, number) > 1) {
            factorFound = 1;
        } else {
            if (bigmod(b, number - 1, number) != 1) {
                return FALSE;
            }
        }
        b++;
    }
    return TRUE;
}

unsigned int gcd(int a, int b) {
    if (b == 0)
        return a;
    gcd(b, a % b);
}

unsigned int bigmod(unsigned int b, unsigned int p, unsigned int m) {
    if (p == 0)
        return 1;
    else if (p % 2 == 0) 
        return square(bigmod(b, p/2, m)) % m;
    else
        return ((b % m) * (bigmod(b, p - 1, m))) % m;
}

unsigned int square(int x) {
    return x * x;
}
