#include<stdio.h>

int binarySearch(int, int, int);

int a[] = {1, 3, 4, 5, 17, 18, 31, 33};

int main(void) {
    int index, value;
    int low = 0;
    int high  = 7;
    scanf("%d", &value);
    while (value != -1) {
        index = binarySearch(value, low, high);
        if (index >= 0)
            printf("Found: %d\n", a[index]);
        else
            printf("Not found!\n");
        scanf("%d", &value);
    }
    return 0;
}

int binarySearch(int value, int low, int high) {
    int mid;
    if (low > high)
        return -1;
    mid = (low + high ) / 2;
    if (value == a[mid])
        return mid;
    if (value < a[value])
        binarySearch(value, low, mid - 1);
    else
        binarySearch(value, mid + 1, high);
}
