#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char func(char n[]){
    int i;
    int number = 0;
    int value;
    char* n1= (char*) malloc(sizeof(char) * 3);

    if(strlen(n) == 1) return n[0];

    for(i = 0; i < strlen(n); i++) {
        value = n[i] - '0';
        number += value;
    }
    sprintf(n1, "%d", number);
    func(n1);
}

int main(void) {

    char first[26];
    char aux[26];
    char second[26];
    char valuesL[27] = "abcdefghijklmnopqrstuvwxyz";
    char valuesU[27] = "ABCDEFGHIJKLMNOPQRSTUVWZYZ";
    int valueF, valueS;
    char sVF[5], sVS[5];
    char cVF, cVS;
    int i, j;
    float percent;
    int v1, v2;
    int flag;

    while(fgets(aux, 27, stdin)) {

        strcpy(first, aux);
        fgets(second, 27, stdin);
        valueF = 0;
        valueS = 0;
        flag = 0;
        for(i = 0; i < strlen(first); i++) {
            for(j = 0; j < 26; j++) {
                if(first[i] == valuesL[j] || first[i] == valuesU[j]) {
                    valueF += j + 1;
                    flag = 1;
                    break;
                }
            }
        }
        for(i = 0; i < strlen(second); i++) {
            for(j = 0; j < 26; j++) {
                if(second[i] == valuesL[j] || second[i] == valuesU[j]) {
                    valueS += j + 1;
                    flag = 1;
                    break;
                }
            }
        }

        sprintf(sVF, "%d", valueF);
        sprintf(sVS, "%d", valueS);

        cVS = func(sVS);
        cVF = func(sVF);

        v1 = cVF - '0';
        v2 =  cVS - '0';

        if(v1) {
            percent = (float) v2 / v1;
            if((percent * 100 > 100) && v2){
                percent = (float) v1 / v2;
            }
        } else
            percent = 0;

        if(flag)
            printf("%.2f \%\n", percent * 100);
        else
            printf("\n");
    }
    return 0;
}
