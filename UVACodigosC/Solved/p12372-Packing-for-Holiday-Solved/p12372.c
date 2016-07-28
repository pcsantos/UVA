#include<stdio.h>

int main(void) {

    int tC;
    int len, wid, hei;
    int i;

    scanf("%d", &tC);
    for(i = 1; i <= tC; i++) {
        scanf(" %d %d %d\n", &len, &wid, &hei);
        if(len <= 20 && wid <= 20 && hei <= 20)
            printf("Case %d: good\n", i);
        else
            printf("Case %d: bad\n", i);
    }
    return 0;
}
