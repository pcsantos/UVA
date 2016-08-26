#include<stdio.h>

int main(void) {
    int n, k;

    while (scanf("%d %d\n", &n, &k) != EOF) {
        printf("%d\n", n + (n - 1) / (k - 1));
    }
    return 0;
}
