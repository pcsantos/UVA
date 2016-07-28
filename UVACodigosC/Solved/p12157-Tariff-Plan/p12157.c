#include<stdio.h>

int main(void) {

    int tC, c;
    int calls, callsD;
    int i, j;
    int mile, juice;
    int times;

    scanf("%d\n", &tC);
    for(i = 1; i <= tC; i++) {
        scanf("%d\n", &calls);
        callsD = 0;
        mile = 0;
        juice = 0;
        times  = 0;
        for(j = 0; j < calls; j++) {
            scanf(" %d", &callsD);
            times  = 0;
            times = callsD / 30;
            mile += times * 10 + 10;

            times = 0;
            times = callsD / 60;
            juice += times * 15 + 15;
        }
        if(mile > juice) {
            printf("Case %d: Juice %d\n", i, juice);
        } else {
            if(juice > mile) {
                printf("Case %d: Mile %d\n", i, mile);
            } else
                printf("Case %d: Mile Juice %d\n", i, mile);
        }
    }
    return 0;
}
