#include<stdio.h>
#include<string.h>

#define SIZE 30

int countSpaces(char[]);
int getMin(int[]);
int calcSpaces(int[], int);

int main(void) {
    char arr[SIZE];
    int spaces[SIZE];
    int rows, i;
    int min;
    scanf("%d\n", &rows);
    while (rows) {
        memset(spaces, -1, sizeof(spaces));
        for(i = 0; i < rows; i++) {
            fgets(arr, SIZE - 1, stdin);
            arr[strlen(arr)- 1] = '\0';
            int sp = countSpaces(arr);
            spaces[sp]++;
        }
        min = getMin(spaces);
        if (min == -1 || rows == 1) {
            printf("0\n");
        } else {
            printf("%d\n", calcSpaces(spaces, min));
        }
        scanf("%d\n", &rows);
    }
    return 0;
}

int calcSpaces(int arr[], int min) {
    int i;
    int spaces = 0;
    for (i = min; i < SIZE; i++) {
        if (arr[i] != -1)
            spaces += (arr[i] + 1) * (i - min);
    }
    return spaces;
}

int getMin(int arr[]) {
    int i;
    int min = -1;
    for (i = 0; i < SIZE; i++)
        if (arr[i] != -1)
            return i;
    return min;
}

int countSpaces(char arr[]) {
    int i;
    int count = 0;
    for (i = 0; arr[i]; i++) {
        if (arr[i] == 32)
            count++;
    }
    return count;
}
