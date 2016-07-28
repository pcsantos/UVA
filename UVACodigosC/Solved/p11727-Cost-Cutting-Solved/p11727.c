#include<stdio.h>

#define SIZE 3

int main(void) {

    int casesNumber;
    int i;
    int salary[SIZE];

    scanf("%d\n", &casesNumber);
    for(i = 1; i <= casesNumber; i++) {
        scanf(" %d %d %d\n", &salary[0], &salary[1], &salary[2]);

        int j, k, aux;
        for(j = SIZE - 1; j >= 1; j--) {
            for(k = 0; k < j; k++) {
                if(salary[k] > salary[k + 1]) {
                    aux = salary[k];
                    salary[k] = salary[k + 1];
                    salary[k + 1] = aux;
                }
            }
        }
        printf("Case %d: %d\n", i, salary[1]);
    }
    return 0;
}
