#include<stdio.h>

int main(void) {

    int tC;
    int balance, event;
    int i, j;

    scanf("%d", &tC);
    j = 1;
    while(tC != 0) {
        balance = 0;
        for(i = 0; i < tC; i++) {
            scanf(" %d", &event);
            if(event)
                balance++;
            else
                balance--;
        }
        printf("Case %d: %d\n", j++, balance);
        scanf("%d", &tC);
    }
    return 0;
}
