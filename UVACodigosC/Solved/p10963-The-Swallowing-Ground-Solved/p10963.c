#include<stdio.h>
#include<math.h>

int main(void) {

    int tC, yN, yS, tColumns;
    int i, j;
    int h, preH, nextH;
    int flag;

    scanf(" %d\n", &tC);
    for(i = 0; i < tC; i++) {
        if(i)
            printf("\n");
        flag = 0;
        preH = -1;
        nextH = 0;
        scanf(" %d\n", &tColumns);
        for(j = 0; j < tColumns; j++) {
            scanf(" %d %d\n", &yN, &yS);
            h =  (yN - yS)*(yN - yS);
            nextH = (int)sqrt(h);
            if(preH >= 0) {
                if(nextH != preH){
                    flag = 1;
                }
            }
            preH = nextH;
        }
        if(flag)
            printf("no\n");
        else
            printf("yes\n");
    }
    return 0;
}
