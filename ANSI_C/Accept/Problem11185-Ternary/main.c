#include<stdio.h>

#define SIZE 25

void convertDecimalToBaseThree(int, int[], int*);

int main(void) {
    int number, size;
    int arr[SIZE], i;

    scanf("%d\n", &number);
    while (number >= 0) {
        convertDecimalToBaseThree(number, arr, &size);
        for (i = size - 1; i >= 0; i--) {
            printf("%d", arr[i]);
        }
        printf("\n");
        scanf("%d\n", &number);
    }
    return 0;
}

void convertDecimalToBaseThree(int number, int arr[], int *size) {
    (*size) = 0;
    if (number == 0) {
        arr[(*size)++]  = 0;
        return;
    }
    do {
        arr[(*size)++] = number % 3;
        number /= 3;
    } while (number > 0);
}
