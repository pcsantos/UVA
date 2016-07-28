#include<stdio.h>

typedef struct _cat {
    int c[100];
    int min;
    int nC;
} Cat;

int main(void) {

    int c[100];
    Cat ca[101];
    int nOfC, nOfCat, nCCat;
    int i, j, k;
    int flag;
    int occ;

    scanf("%d", &nOfC);
    while(nOfC) {
        scanf(" %d\n", &nOfCat);
        for(i = 0; i < nOfC; i++) {
            scanf(" %d", &c[i]);
            flag = 0;
            for(j = 0; j <= i; j++) {
                if(c[j] == c[i]) flag++;
                if(flag > 1) {
                    c[j] = 0;
                    break;
                }
            }
        }
        for(i = 0; i < nOfCat; i++) {
            scanf(" %d", &nCCat);
            ca[i].nC = nCCat;
            scanf(" %d", &ca[i].min);
            for(j = 0; j < nCCat; j++) {
                scanf(" %d", &ca[i].c[j]);
            }
        }

        flag = 1;
        for(i = 0; i < nOfCat; i++) {
            occ = 0;
            for(j = 0; j < ca[i].nC; j++) {
                for(k = 0; k < nOfC; k++) {
                    if(c[k] == ca[i].c[j]) {
                        occ++;
                    }
                }
            }
            if(occ < ca[i].min)
                flag = 0;
        }
        if(flag)
            printf("yes\n");
        else
            printf("no\n");

        scanf("%d", &nOfC);
    }
    return 0;
}
