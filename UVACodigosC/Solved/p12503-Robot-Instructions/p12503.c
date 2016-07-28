#include<stdio.h>
#include<string.h>

typedef struct _coord{
    char name[6];
    int action;
} Coord;

int main(void) {

    int tC, nI;
    int i, j, k;
    char inst[6], aux[3];
    Coord c[100];
    int pos, next;

    scanf(" %d\n", &tC);
    for(i = 0; i < tC; i++) {
        pos = 0;
        scanf(" %d\n", &nI);
        for(j = 0; j < nI; j++) {
            scanf(" %s ", inst);
            if(strcmp(inst, "LEFT") == 0) {
                strcpy(c[j].name, inst);
                c[j].action = -1;
            }
            if(strcmp(inst, "RIGHT") == 0) {
                strcpy(c[j].name, inst);
                c[j].action = +1;
            }
            if(strcmp(inst, "SAME") == 0) {
                scanf("%s %d\n", aux, &next);
                strcpy(c[j].name, inst);
                c[j].action = next - 1;
            }
        }
        for(j = 0; j < nI; j++) {
            if(strcmp(c[j].name, "LEFT") == 0) {
                pos += c[j].action;
            } else {
                if(strcmp(c[j].name, "RIGHT") == 0) {
                    pos += c[j].action;
                } else {
                    k = j;
                    while(strcmp(c[k].name, "SAME") == 0) {
                        k = c[k].action;
                    }
                    pos += c[k].action;
                }
            }
        }
        printf("%d\n", pos);
    }
    return 0;
}
