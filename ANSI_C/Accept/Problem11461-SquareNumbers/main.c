#include<stdio.h>
#include<string.h>
#include<math.h>

#define SIZE 100001
#define TRUE 1
#define FALSE 0

void initArr();
int isSQRT(int);

int arr[SIZE];

int main(void) {
    int low, high;
    memset(arr, 0, sizeof(arr));
    initArr();   
    scanf("%d %d\n", &low, &high);
    while (low && high) {
        printf("%d\n", arr[high] - arr[low - 1]); 
        scanf("%d %d\n", &low, &high);
    }
    return 0;
}

void initArr() {
    int i = 0;
    for (i = 1; i < SIZE; i++) {
        if (isSQRT(i)) {
            arr[i] = arr[i - 1] + 1;
        } else
            arr[i] = arr[i - 1];
    }
}

int isSQRT(int n) {
    int v = sqrt(n);
    return n == v * v ? TRUE : FALSE;
}
