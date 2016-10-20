#include<stdio.h>
#include<string.h>
#include<stdlib.h>

#define SIZE 200
#define gc() getchar_unlocked()

void code(char[], int, int);
void copyArray(char[], char[], int);
void prepareWord(char[], int);
int cmp(const void*, const void*);
int cycle(int);

int index[SIZE];

int main(void) {
    char str[SIZE + 1];
    int size, cyc;
    int i, k;
    memset(index, 0, sizeof(index));
    memset(str, ' ', sizeof(str));
    scanf("%d\n", &size);
    while (size != 0) {
        for (i = 0; i < size; i++)
            scanf("%d ", &index[i]);
        scanf("%d", &k);
        cyc = cycle(size);
        while (k != 0) {
            i = 0;
            getchar();
            while(str[i] = gc()) {
                if (str[i] == '\n') {
                    str[i] = '\0';
                    break;
                }
                i++;
            } 
            prepareWord(str, size);
            code(str, size, k % cyc);
            scanf("%d", &k);
        }
        printf("\n");
        scanf("%d\n", &size);
    }
    return 0;
}

void prepareWord(char str[], int size) {
    int len = strlen(str);
    int i;
    for (i = len; i < size; i++) {
        str[i] = ' ';
    }
    str[i] = '\0';
}

void code(char str[], int size, int k) {
    int i, j;
    char aux[SIZE  + 1];
    copyArray(aux, str, size);
    for (j = 0;  j < k; j++) {
        if (j % 2 == 0) {
            for (i = 0 ; i < size; i++)
                aux[index[i] - 1] = str[i];            
        }
        else {
            for (i = 0; i < size; i++)
                str[index[i] - 1] = aux[i];
        }
    }
    if (j % 2 == 0)
        printf("%s\n", str);
    else
        printf("%s\n", aux);
}

void copyArray(char a[], char b[], int size) {
    int i;
    for (i = 0; i < size; i++)
        a[i] = b[i];
    a[i] = '\0';
}

int cycle(int size) {
    int aux[size];
    int i, j, k;
    int len = 1;
    for (i = 0; i < size; i++)
        aux[i] = i;
    for (i = 0; i < size; i++) {
        j = i;
        k = index[j] - 1;
        while (i != k) {
            j = k;
            k = index[j] - 1;
            len++;
        }
        aux[i] = len;
        len = 1;
    }
    qsort(aux, size, sizeof(int), cmp);
    int mul = aux[0];
    for (i = 1; i < size; i++)
        if (aux[i] != aux[i - 1])
            mul *= aux[i];
    return mul;
}

int cmp(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}
