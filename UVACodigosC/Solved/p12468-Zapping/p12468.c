#include<stdio.h>

int main(void) {

    int actualCh;
    int nextCh;
    int bP;

    scanf(" %d %d\n", &actualCh, &nextCh);
    while(actualCh != -1 && nextCh != -1) {
        bP = 0;
        if(actualCh < nextCh) {
            bP = nextCh - actualCh;
            if(actualCh + 99 - nextCh < bP)
                bP = actualCh + 99 - nextCh + 1;
        }
        if(actualCh > nextCh) {
            bP = actualCh - nextCh;
            if(99 - actualCh + nextCh < bP)
                bP = 99 - actualCh + nextCh + 1;
        }
        printf("%d\n", bP);
        scanf(" %d %d\n", &actualCh, &nextCh);
    }
    return 0;
}
