/*Values incorrects to big numbers like C(99,50), but for this problem is good enougth*/
#include<stdio.h>

#define MAXN 100
#define MAXK 100

long int C[MAXN + 1][MAXK + 1];

void binCoeff(int, int);
int min(int, int);

int main(void) {
    int n, k;
    binCoeff(MAXN, MAXK);
    scanf("%d %d\n", &n, &k);
    while (n && k) {
        printf("%d things taken %d at a time is %ld exactly.\n", n, k, C[n][k]);
        scanf("%d %d\n", &n, &k);
    }
    return 0;
}

void binCoeff(int n, int k) {
    int i, j;

    for (i = 0; i <= n; i++) {
        for (j = 0; j <= min(i, k); j++){
            if (j == 0 || j == i) {
                C[i][j] = 1;
            } else {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
    }
}

int min(int a, int b) {
    return a < b? a : b;
}
