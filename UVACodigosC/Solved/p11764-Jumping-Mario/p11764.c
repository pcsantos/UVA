#include<stdio.h>

int main(void) {

    int tC, nW;
    int actualH, nextH;
    int i, j;
    int lJ, hJ;

    scanf(" %d\n", &tC);
    for(i = 1; i <= tC; i++) {
        scanf(" %d\n", &nW);
        lJ = 0;
        hJ = 0;
        scanf("%d", &actualH);
        for(j = 0; j < nW - 1; j++) {
            scanf("%d", &nextH);
            if(actualH < nextH)
                hJ++;
            else {
                if(nextH < actualH)
                     lJ++;
            }
            actualH = nextH;
        }
        printf("Case %d: %d %d\n", i, hJ, lJ);
    }
    return 0;
}
