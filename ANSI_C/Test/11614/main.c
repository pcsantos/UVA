#include<stdio.h>

int main(void) {
    unsigned long long i;
    unsigned long long aux = 0;
    for (i = 1; i < 1000000000000000000; i++) {
        if (aux > 99999999999999999) break;
        aux = aux + i;
        printf("%llu\n", aux);
    }

    return 0;
}

