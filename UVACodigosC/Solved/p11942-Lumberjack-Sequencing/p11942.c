#include<stdio.h>

int main(void) {

    int tC;
    int i, j, flag;
    int v, nextV;

    scanf(" %d\n", &tC);
    for(i = 0; i < tC; i++) {
        if(i == 0)
            printf("Lumberjacks:\n");
        flag = 1;
        scanf("%d", &v);
        scanf("%d", &nextV);
        if(v < nextV) {
            v = nextV;
            for(j = 0; j < 8; j++) {
                scanf("%d", &nextV);
                if(v > nextV) {
                    flag = 0;
                }
                v = nextV;
            }
        } else {
            v = nextV;
            for(j = 0; j < 8; j++) {
                scanf("%d", &nextV);
                if(v < nextV) {
                    flag = 0;
                }
                v = nextV;
            }
        }
        if(flag)
            printf("Ordered\n");
        else
            printf("Unordered\n");
    }
    return 0;
}
