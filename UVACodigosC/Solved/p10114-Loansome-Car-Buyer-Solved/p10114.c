#include<stdio.h>

typedef struct _dRecords{
    int month;
    float dPercent;
} DRecords;


int main(void) {

    int lD;
    float dP;
    float lV;
    int dR;
    DRecords rec[100];
    int flag, month;
    float actualValue;
    float actualLoan;
    int i, j;
    float parc;

    scanf(" %d %f %f %d", &lD, &dP, &lV, &dR);
    while(lD > 0) {
        flag = 0;
        month = 0;
        actualLoan = lV;
        actualValue = dP + lV;
        parc = lV / lD;
        for(i = 0; i < dR; i++) {
            scanf(" %d %f\n", &rec[i].month, &rec[i].dPercent);
        }

        if(dR == 1) {
            actualValue *=(1 - rec[0].dPercent);
            if(actualValue > actualLoan) {
                month = 0;
                flag = 1;
                j = lD;
            }
        }

        for(i = 0; i < dR - 1; i++) {
            for(j = rec[i].month; j < rec[i + 1].month; j++) {
                actualValue *=(1 - rec[i].dPercent);
                if(j)
                    actualLoan -=  parc;
                if(actualValue > actualLoan) {
                    month = j;
                    flag = 1;
                    j = lD;
                    break;
                }
            }
        }

        for(i = j; i < lD; i++) {
            actualValue *=(1 - rec[dR - 1].dPercent);
            actualLoan -= parc;
            if(actualValue > actualLoan) {
                    month = i;
                    flag = 1;
                    break;
            }
        }

        if(flag) {
            if(month != 1)
            printf("%d months\n", month);
        else
            printf("%d month\n", month);
        } else
            printf("100 months\n");

        scanf(" %d %f %f %d", &lD, &dP, &lV, &dR);
    }
    return 0;
}
