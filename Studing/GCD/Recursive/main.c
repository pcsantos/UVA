#include<stdio.h>

int gcd(int, int);
int gcdLine(int, int);
int main(void) {
    int a, b;

    while (scanf("%d %d\n", &a, &b) != EOF) {
        printf("gcd(%d, %d) = %d\n", a, b, gcd(a, b));
        printf("gcd(%d, %d) = %d\n", a, b, gcdLine(a, b));
    }

    return 0;
}

int gcdLine(int a, int b) {
    if (b == 0)
        return a;
    gcd(b, a % b);
}

int gcd(int a, int b) {
    if (b <= a && a % b == 0)
        return b;
    if (a < b)
        gcd(b, a);
    gcd(b, a % b);
}
