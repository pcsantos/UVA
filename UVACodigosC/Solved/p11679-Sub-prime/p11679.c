#include<stdio.h>

typedef struct _bank {
    int reserves;
    int debit;
    int credit;
} Bank;

int main() {

    Bank banks[20];
    int b, nD;
    int dB, cB, value;
    int i;
    int flag;

    scanf(" %d %d\n", &b, &nD);
    while(b && nD) {
        flag = 0;
        for(i = 1; i <= b; i++) {
            banks[i].credit = 0;
            banks[i].debit = 0;
            banks[i].reserves = 0;
            scanf(" %d", &banks[i].reserves);
        }
        for(i = 0; i < nD; i++) {
            scanf(" %d %d %d", &dB, &cB, &value);
            banks[dB].debit -= value;
            banks[cB].credit += value;
        }
        for(i = 1; i <= b; i++) {
            banks[i].reserves += banks[i].debit + banks[i].credit;
            if(banks[i].reserves < 0) flag = 1;
        }
        if(flag)
            printf("N\n");
        else
            printf("S\n");
        scanf(" %d %d\n", &b, &nD);
    }
    return 0;
}
