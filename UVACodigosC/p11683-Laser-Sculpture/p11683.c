#include<stdio.h>

int main(void) {

    int cols[10000];
    int h, l;
    int i;
    int pre;
    int turnedOn;

    scanf(" %d %d\n", &h, &l);
    while(h && l) {
        for(i = 0; i < l; i++) {
            scanf(" %d", &cols[i]);
        }

        pre = cols[0];
        turnedOn = h - pre;
        for(i = 1; i < l; i++) {
            if(cols[i] < pre) {
                turnedOn += pre - cols[i];
            }
            pre = cols[i];
        }

        printf("%d\n", turnedOn);
        scanf(" %d %d\n", &h, &l);
    }
    return 0;
}
