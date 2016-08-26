#include<stdio.h>

int main(void) {
    int rows, cols;
    while (scanf("%d %d\n", &rows, &cols) != EOF) {
        printf("%d\n", (rows * cols - 1));
    }
    return 0;
}
