#include<stdio.h>

int binCoeff(int, int);

int main(void) {
    int n, k;

    while (scanf("%d %d\n", &n, &k) != EOF) {
        printf("Value of C(%d,%d) is %d.\n", n, k, binCoeff(n, k));
    }

    return 0;
}

int binCoeff(int n, int k) {

    if (k == 0 || k == n)
        return 1;

    return binCoeff(n - 1, k - 1) + binCoeff(n - 1, k);
}
