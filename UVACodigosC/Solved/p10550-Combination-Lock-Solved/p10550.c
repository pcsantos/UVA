#include<stdio.h>

int main(void) {

    int iP, fC, sC, tC;
    int turns;
    int turn = 40;

    scanf(" %d %d %d %d", &iP, &fC, &sC, &tC);
    while(iP || fC || sC || tC){
        turns = 0;
        if(iP > fC)
            turns += turn * 2 + iP - fC;
        else {
            if(fC > iP)
                turns += turn * 2 + turn - fC + iP;
            else
                turns += turn * 2;
        }
        if(fC > sC)
            turns += turn + turn - fC + sC;
        else {
            if(sC > fC)
                turns += turn + sC - fC;
            else
                turns += turn;
        }
        if(sC > tC)
            turns += sC - tC;
        else {
            if(tC > sC)
                turns += turn - tC + sC;
        }
        printf("%d\n", turns * 9);
        scanf(" %d %d %d %d", &iP, &fC, &sC, &tC);
    }
}
