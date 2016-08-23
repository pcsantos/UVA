#include<stdio.h>

#define SIZE 100
#define TRUE 1
#define FALSE 0

int matrix[SIZE][SIZE];

void printMatrix(int);
void classifyMatrix(int);
int rowIsNotOk(int, int);
int colIsNotOk(int, int);

int main(void) {
    int size;
    int i, j;
    int value;

    scanf("%d\n", &size);
    while (size != 0) {
        for (i = 1; i <= size; i++) {
            for (j  = 1; j <= size; j++) {
                scanf(" %d ", &matrix[i][j]);
            }
        }
        classifyMatrix(size);
        scanf("%d\n", &size);
    }

    return 0;
}

void classifyMatrix(int size) {
    int row = 0;
    int col = 0;
    int i;

    for (i = 1; i <= size; i++) {
        if (rowIsNotOk(i, size)) {
            if (row == 0)
                row = i;
            else {
                printf("Corrupt\n");
                return;
            }
        }
        if (colIsNotOk(i, size)) {
            if (col == 0)
                col = i;
            else {
                printf("Corrupt\n");
                return;
            }
        }  
    }
    if (col != 0 && row != 0)
        printf("Change bit (%d,%d)\n", row, col);
    else
        printf("OK\n");
}

int rowIsNotOk(int row, int size) {
    int sum = 0;
    int j;
    for (j = 1; j <= size; j++)
        sum += matrix[row][j];

    return sum % 2 != 0 ? TRUE : FALSE;
}

int colIsNotOk(int col, int size) {
    int sum = 0;
    int i;
    for (i = 1; i <= size; i++)
        sum += matrix[i][col];

    return sum % 2 != 0 ? TRUE : FALSE;
}
