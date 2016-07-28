#include<stdio.h>

int main(void) {

    int caseNumbers;
    int creatures;
    int clowSpeed;
    int creatureSpeed;
    int i, j;

    while(scanf("%d\n", &caseNumbers) != EOF) {
        for(j = 1; j <= caseNumbers; j++) {
            scanf("%d", &creatures);
            clowSpeed = 0;
            for(i = 0; i < creatures; i++) {
                scanf("%d", &creatureSpeed);
                if(clowSpeed < creatureSpeed)
                    clowSpeed = creatureSpeed;
            }
            printf("Case %d: %d\n", j, clowSpeed);
        }
    }
    return 0;
}
