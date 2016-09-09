#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int cmp(const void*, const void*);

int main(void) {
    char word[] = "teste";
    printf("%s\n", word);
    qsort(word, strlen(word), sizeof(char), cmp);
    printf("%s\n", word);
    return 0;
}

int cmp(const void *a, const void *b) {
    char *chA = (char*)a;
    char *chB = (char*)b;
    if (*chA > *chB)
        return 1;
    if (*chB > *chA)
        return -1;
    return 0;
}
