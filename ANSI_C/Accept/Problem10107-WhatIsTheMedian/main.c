#include<stdio.h>
#include<stdlib.h>

#define MAX_SIZE 10000
#define TRUE 1
#define FALSE 0;

unsigned long int array[MAX_SIZE];

int compare(const void *, const void *);

int main(void) {
    int size = 0;
    int i = 0;
    while (scanf("%lu\n", &array[size++]) != EOF) {
        qsort(array, size, sizeof(unsigned long int), compare);
        if (i % 2 == 0) {
            printf("%lu\n", array[i/2]);
        } else {
            printf("%lu\n", (array[i/2] + array[i/2 + 1]) / 2);
        }
        i++;
    }

    return 0;
}

int compare(const void *a, const void *b) {
    return (*(unsigned long int*)a - *(unsigned long int*)b);
}
