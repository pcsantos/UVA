#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<limits.h>

#define SIZE 1001

int cmp(const void*, const void*);
void removeRepetition();
int sum(int);
int arr[SIZE];
int size;

int main(void) {
    int value, cases;
    int i, queries;
    int query;

    scanf("%d\n", &size);
    cases = 1;
    while (size) {
        for (i = 0; i < size; i++)
            scanf("%d\n", &arr[i]);
        
        qsort(arr, size, sizeof(int), cmp);
        /*removeRepetition();*/
        scanf("%d\n", &queries);
        printf("Case %d:\n", cases++);
        for (i = 0; i < queries; i++) {
            scanf("%d\n", &query);
            printf("Closest sum to %d is %d.\n", query, sum(query));
        }
        scanf("%d\n", &size);
    }

    return 0;
}

int sum(int query) {
    int i, retSum;
    int s, j;
    int currentDiff;
    int globalDiff = INT_MAX;
    for (i = 0; i < size; i++) {
        for (j = i + 1; j < size; j++) {
            s = arr[i] + arr[j];
            currentDiff = abs(s - query);
            /*printf("Currentdiff: %d ", currentDiff);
            printf("i: %d j: %d sum: %d\n", i, j, s);*/
            if (currentDiff < globalDiff) {
                if (currentDiff == 0) return query;
                retSum = s;
                globalDiff = currentDiff;
            }
        }
    }
    return retSum;
}

int cmp(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

void removeRepetition() {
    int aux[SIZE], j;
    int i, newSize = size;
    aux[0] = arr[0];
    j = 1;
    for (i = 1; i < size; i++) {
        if (arr[i] != arr[i - 1]) {
            aux[j++] = arr[i];
        } else {
            newSize--;
        }
    }
    for (i = 0; i < newSize; i++) {
        arr[i] = aux[i];
    }
    size = newSize;
}
