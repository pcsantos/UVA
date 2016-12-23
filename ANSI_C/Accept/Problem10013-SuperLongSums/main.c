#include<stdio.h>

#define SIZE 1000000

int a[SIZE];
int b[SIZE];
int sum[SIZE];

int main(void) {
    int testCases;
    int size, i, j;
    int over = 0;
    int auxSum;

    scanf("%d\n", &testCases);
    for (i = 0; i < testCases; i++) {
        if (i > 0) 
            printf("\n");
        scanf("%d\n", &size);
        for (j = 0; j < size; j++) {
            scanf("%d %d\n", &a[j], &b[j]);
        }
        over = 0;
        for (j = size - 1; j >= 0; j--) {
            auxSum = a[j] + b[j] + over;
            if (auxSum >= 10) {
                sum[j] = auxSum % 10;
                over = 1;
            } else {
                sum[j] = auxSum;
                over = 0;
            }
        }
        if (over)
            printf("1");
        for (j = 0; j < size; j++)
            printf("%d", sum[j]);
        printf("\n");
    }
    return 0;
}
