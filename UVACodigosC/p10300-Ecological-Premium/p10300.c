#include<stdio.h>

int main(void) {

    int tC, fN, fY, nA, fF;
    int i, j;
    float value;
    float avg;
    float prem;
    scanf(" %d\n", &tC);
    for(i = 0; i < tC; i++) {
        scanf(" %d\n", &fN);
        value = 0;
        for(j = 0; j < fN; j++) {
            scanf(" %d %d %d\n", &fY, &nA, &fF);
            avg = (float) fY / nA;
            prem = (float) avg * fF;

            value += (float) prem * nA;
        }
        printf("%.0f\n", value);
    }

    return 0;
}
