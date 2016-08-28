#include<stdio.h>

int gcd(int, int);

int main(void) {
    int a, b;

    while (scanf("%d %d\n", &a, &b) != EOF) {
        printf("gcd(%d, %d) = %d\n", a, b, gcd(a, b));
    }

    return 0;
}

int gcd(int a, int b) {
    if (b <= a && a % b == 0)
        return b;
    if (a < b)
        gcd(b, a);
    gcd(b, a % b);
}
