#include<stdio.h>

#define SIZE 51

long long arr[SIZE];

void initArr();

int main(void) {
    int value;
    initArr();
    scanf("%d\n", &value);
    while (value) {
        printf("%lld\n", arr[value]);
        scanf("%d\n", &value);
    }
    return 0;
}

void initArr() {
    int i;
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 2;
    arr[3] = 3;
    for (i = 4; i < SIZE; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
    }
}
