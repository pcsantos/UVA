#include<stdio.h>

int main(void) {
    int numerator, denominator;
    int aux;
    int flag, first;
    while (scanf("%d %d\n", &numerator, &denominator) != EOF) {
        printf("[%d", numerator / denominator);
        aux = numerator;
        flag = 1;
        first = 1;
        while (denominator) {
            numerator = denominator;
            denominator = aux % denominator;
            if(denominator) {
                if (denominator != 1) {
                    if (first) {
                        printf(";%d", numerator / denominator);
                        first = 0;
                    } else
                        printf(",%d", numerator / denominator);
                }
                if (denominator == 1) {
                    if (first) {
                        printf(";%d]\n", numerator); 
                        first = 0;
                    } else
                        printf(",%d]\n", numerator);
                    flag = 0;
                }
            }
            aux = numerator;
        }
        if (flag)
            printf("]\n");
    }
    return 0;
}
