#include<stdio.h>

long bigmod(long, long, long);
long square(long);

int main(void) {
    long b, p, m;

    while (scanf("%ld %ld %ld", &b, &p, &m) != EOF) {
        printf("%ld\n", bigmod(b, p, m));
    }
    return 0;
}

long bigmod(long b, long p, long m) {
    if (p == 0)
        return 1;
    else if (p % 2 == 0) 
        return square(bigmod(b, p/2, m)) % m;
    else
        return ((b % m) * bigmod(b, p - 1, m)) % m;
}

long square(long x) {
    return x * x;
}
