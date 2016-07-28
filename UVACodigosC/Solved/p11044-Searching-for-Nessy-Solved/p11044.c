#include<stdio.h>

int main(void) {

    int cT;
    int r, c;
    int i, j, k;
    int sonar;

    scanf("%d", &cT);
    for(i = 0; i < cT; i++) {
        scanf(" %d %d\n", &r, &c);
        sonar = 0;
        for(k = 2; k < r; k += 3) {
            for(j = 2; j < c; j += 3) {
                sonar++;
            }
        }
        printf("%d\n", sonar);
    }
    return 0;
}
