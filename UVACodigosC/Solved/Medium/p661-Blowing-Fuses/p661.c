#include<stdio.h>

typedef struct _device {
    int cpt;
    int state;
} Device;

int main(void) {
    Device devs[20];
    int nDev, nOperf, cap;
    int cptFuse, cptFuseMax;
    int tgg;
    int i, j, flag;

    scanf("%d %d %d\n", &nDev, &nOperf, &cap);
    j = 1;
    while(nDev && nOperf && cap) {
        for(i = 0; i < nDev; i++) {
            devs[i].cpt = 0;
            devs[i].state = 0;
            scanf(" %d\n", &devs[i].cpt);
        }
        cptFuseMax = 0;
        cptFuse = 0;
        flag = 0;
        for(i = 0; i < nOperf; i++) {
            scanf(" %d\n", &tgg);
            if(devs[tgg - 1].state){
                devs[tgg - 1].state = 0;
                cptFuse -= devs[tgg - 1].cpt;
            } else {
                devs[tgg - 1].state = 1;
                cptFuse += devs[tgg - 1].cpt;
                if(cptFuseMax < cptFuse)
                    cptFuseMax = cptFuse;
                if(cap < cptFuse) {
                    flag = 1;
                }
            }
        }
        printf("Sequence %d\n", j++);
        if(flag)
            printf("Fuse was blown.\n\n");
        else {
            printf("Fuse was not blown.\n");
            printf("Maximal power consumption was %d amperes.\n\n", cptFuseMax);
        }
        scanf("%d %d %d\n", &nDev, &nOperf, &cap);
    }
    return 0;
}
