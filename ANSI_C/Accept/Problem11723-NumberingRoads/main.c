#include<stdio.h>

#define MAX 27
#define TRUE 1
#define FALSE 0

int suffixes(int, int, int*);

int main(void) {
    int streets, numbers;
    int suff, index = 1;
    scanf("%d %d\n", &streets, &numbers);
    while (streets && numbers) {
        if (suffixes(streets, numbers, &suff))
            printf("Case %d: %d\n", index++, suff);
        else
            printf("Case %d: impossible\n", index++);
        scanf("%d %d\n", &streets, &numbers);
    }
    return 0;
}

int suffixes(int st, int n, int *suff) {
    int i, necessary;
    if (st - n <= 0) {
        (*suff) = 0;
        return TRUE;
    }
    for (i = 1; i < MAX; i++) {
        necessary = n * i + n;
        if (st <= necessary) {
            (*suff) = i;
            return TRUE;
        }
    }
    return FALSE;
}
