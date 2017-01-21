#include<stdio.h>

#define TRUE 1
#define FALSE 0
#define MAXCARS 1000

typedef struct _initial {
    int carNumber;
    int position;
} initial;

typedef struct _last {
    int carNumber;
    int visited;
} last;

initial arrInitial[MAXCARS];
last arrFinal[MAXCARS];

int main(void) {
    int cars, i;
    int index, defective;

    scanf("%d\n", &cars);
    while(cars) {
        for (i = 0; i < cars; i++) 
            scanf("%d %d\n", &arrInitial[i].carNumber, &arrInitial[i].position);
        for (i = 0; i < cars; i++) 
            arrFinal[i].visited = FALSE;
        defective = FALSE;
        for (i = 0; i < cars; i++) {
            index = arrInitial[i].position + i;
            if (index >= 0 && index < cars) {
                if (arrFinal[index].visited == TRUE) {
                    defective = TRUE;
                    break;
                } else {
                    arrFinal[index].carNumber = arrInitial[i].carNumber;
                    arrFinal[index].visited = TRUE;
                }
            } else {
                defective = TRUE;
                break;
            }
        }
        if (defective)
            printf("-1\n");
        else {
            printf("%d", arrFinal[0].carNumber);
            for (i = 1; i < cars; i++)
                printf(" %d", arrFinal[i].carNumber);
            printf("\n");
        }
        scanf("%d\n", &cars);
    }
    return 0;
}
