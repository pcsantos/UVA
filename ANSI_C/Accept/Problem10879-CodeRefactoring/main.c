#include<stdio.h>

int main(void) {
    
    int ways = 0;
    int i, j, k;
    int testCases, value;
    scanf("%d\n", &testCases);
    for (i = 1; i <= testCases; i++) {
        scanf("%d\n", &value);
        ways = 0;
        printf("Case #%d: %d", i, value);
        for (j = 2; j <= value / j; j++) {
            k = value / j;
            if (j * k == value) {
                printf(" = %d * %d", j, k);
                ways++;
                if (ways == 2) {
                    printf("\n");
                    break;
                }
            }
        }
    }
    return 0;
}
