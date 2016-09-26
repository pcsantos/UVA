#include<stdio.h>
#include<limits.h>

#define SIZE 18

int maxProdcut(int);
int max(int, int);

int arr[SIZE];

int main(void) {
    int nElements;
    int i, cases;

    cases = 1;
    while (scanf("%d\n", &nElements) != EOF) {
        if (cases > 1)
            printf("\n");
        for (i = 0; i < nElements; i++) {
            scanf("%d ", &arr[i]);
        }
        printf("Case #%d: The maximum product is %lld.\n", cases++, maxProduct(nElements));
    }
    return 0;
}

int maxProduct(int n) {
    int subArraySize, startIndex;
    int i;
    int globalMax = INT_MIN;
    for (subArraySize = 2; subArraySize <= n; subArraySize++) {
        for (startIndex = 0; startIndex < n; startIndex++) {
            if (startIndex + subArraySize > n)
                break;
            int prod = 1;
            for (i = startIndex; i < (startIndex + subArraySize); i++)
                prod *= arr[i];
            globalMax = max(globalMax, prod);
        }
    }
    return globalMax > 0 ? globalMax : 0;
}

int max(int a, int b) {
    return a > b ? a : b;
}
