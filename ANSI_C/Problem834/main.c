#include<stdio.h>

int main(void) {
    int numerator, denominator;
    int aux;
    while (scanf("%d %d\n", &numerator, &denominator) != EOF) {
        printf("[%d;", numerator / denominator);
        aux = denominator;
        while (aux > 1) {
            denominator = aux % denominator;
            numerator = aux;
            /*printf("\n%d %d\n", aux, denominator);*/
            if(denominator)
                printf("%d,", aux / denominator);
        }
    }
    return 0;
}
