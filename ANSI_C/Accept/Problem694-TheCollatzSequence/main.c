#include<stdio.h>

#define TRUE 1
#define FALSE 0

int main(void) {
    unsigned long int nextValue;
    long int A, aux, limit;
    int terms;
    int flag;
    int cases = 1;
    scanf("%ld %ld\n", &A, &limit);
    while (A > 0 && limit > 0) {
        terms = 1;
        flag = FALSE;
        aux = A;
        while (aux != 1) {
            if (aux % 2 == 0) {
                aux /= 2;
            } else {
                nextValue = 3 * aux + 1;
                if (nextValue > limit)
                    flag = TRUE;
                else
                    aux = nextValue;
            }
            if (flag)
                break;
            terms++;
        }
        printf("Case %d: A = %ld, limit = %ld, number of terms = %d\n", cases++, A, limit, terms);
        scanf("%ld %ld\n", &A, &limit);
    }
    return 0;
}
