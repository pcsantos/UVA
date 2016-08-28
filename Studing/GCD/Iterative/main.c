#include<stdio.h>

int gcd(int, int);

int main(void) {
    int a, b;

    while (scanf("%d %d\n", &a, &b) != EOF) {
        printf("gcd(%d, %d) = %d\n", a, b, gcd(a, b));
    }

    return 0;
}

/*b > a*/
int gcd(int a, int b) {
    int aux;
    while (b != 0) {
        aux = b;
        b = a % b;
        a = aux;
    }
    return a;
}
