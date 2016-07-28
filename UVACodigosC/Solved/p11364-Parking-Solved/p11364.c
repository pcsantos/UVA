#include<stdio.h>

int main(void) {

    int tC, sToV, p;
    int i, j;
    int min, max;

    scanf(" %d\n", &tC);
    for(i = 0; i < tC; i++) {
        min = 101;
        max = 0;
        scanf(" %d\n", &sToV);
        for(j = 0; j < sToV; j++) {
            scanf("%d", &p);
            if(min > p) min = p;
            if(max < p) max = p;
        }
        printf("%d\n", (max - min) * 2);
    }
    return 0;
}
