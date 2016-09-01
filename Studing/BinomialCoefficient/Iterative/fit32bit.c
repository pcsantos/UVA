#include<stdio.h>

long gcd(long, long);
void divBygcd(long*, long*);
long comb(int, int);

int main(void) {

    printf("%d\n", comb(10, 5));
    return 0;
}

long gcd(long a, long b) {
    if (a % b == 0)
        return b;
    else
        return gcd(b, a % b);
}

void divBygcd(long *a, long *b) {
    long g = gcd((*a), (*b));
    *a /= g;
    *b /= g;
}

long comb(int n, int k) {
    long numerator = 1;
    long denominator = 1;
    long toMult, toDiv, i;
    if ( k > n / 2)
        k = n - k;
    for (i = k; i; i--) {
        toMult = n - k + i;
        toDiv = i;
        divBygcd(&toMult, &toDiv);
        divBygcd(&numerator, &toDiv);
        divBygcd(&toMult, &denominator);
        numerator *= toMult;
        denominator *=toDiv;
    }
    return numerator / denominator;
}
