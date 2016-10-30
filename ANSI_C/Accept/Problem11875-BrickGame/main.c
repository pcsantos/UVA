#include<stdio.h>

int main(void) {
    int testCases, i, j;
    int nElements;
    int value;

    scanf("%d\n", &testCases);
    for (i = 1; i <= testCases; i++) {
        scanf("%d", &nElements);
        for (j = 0; j < nElements; j++) { 
            scanf("%d", &value);
            if (j == nElements / 2)
                printf("Case %d: %d\n", i, value);
        }
    }
    return 0;
}
