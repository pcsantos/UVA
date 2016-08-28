#include<stdio.h>

long int maxsequence;
long int size;

void process(long int, long int);

long int main(void) {
    long int low, high;
    long int aux;
    scanf("%ld %ld\n", &low, &high);
    while(low && high) {
        if (low > high) {
            aux = low;
            low = high;
            high = aux;
        }
        process(low, high);
        printf("Between %ld and %ld, %ld generates the longest sequence of %ld values.\n", 
                                                            low, high, maxsequence, size);
        scanf("%ld %ld\n", &low, &high);
    }
    return 0;
}

void process(long int low, long int high) {
    long int i, count;
    long int aux;
    size = 0;
    for (i = low; i <= high; i++) {
        count = 0;
        aux = i;
        do {
            if (aux % 2 == 0) {
                aux /= 2;
            } else {
                aux = 3 * aux + 1;
            }
            count++;
        } while (aux != 1);
        if (count > size) {
            maxsequence = i;
            size = count;
        }
    }
}
